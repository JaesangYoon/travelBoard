package com.travelBoard.controller;

import com.travelBoard.domain.BoardDto;
import com.travelBoard.domain.PageHandler;
import com.travelBoard.domain.SearchCondition;
import com.travelBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @PostMapping("/modify")
    public String modify(BoardDto boardDto, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        boardDto.setWriter(writer);

        try {
            int rowCnt = boardService.modify(boardDto);

            if (rowCnt != 1)
                throw new Exception("modify failed");

            rattr.addFlashAttribute("msg", "MOD_OK");

            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(boardDto);
            m.addAttribute("msg", "WRT_ERR");
            return "board";
        }
    }

    @GetMapping("/write") // boardList에서 게시물 버튼
    public String write(Model m) {
        m.addAttribute("mode", "new");
        return "board"; // board.jsp는 읽기, 쓰기 모두에서 사용됨. 쓰기일때는 mode=new.
    }

    @PostMapping("/write") // 게시물 등록
    public String write(BoardDto boardDto, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        boardDto.setWriter(writer);

        try {
            int rowCnt = boardService.write(boardDto);

            if (rowCnt != 1)
                throw new Exception("Write failed");

            rattr.addFlashAttribute("msg", "WRT_OK");

            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(boardDto);
            m.addAttribute("msg", "WRT_ERR");
            return "board";
        }
    }

    @PostMapping("/remove")
    public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
       String writer = (String)session.getAttribute("id");
        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

            int rowCnt = boardService.remove(bno, writer);

            if (rowCnt != 1)
                throw new Exception("Board remove error.");

            rattr.addFlashAttribute("msg", "DEL_OK");

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
            // RedirectAttributes의 addFlashAttrubute()는 session을 이용해서 잠깐 저장했다가 한번 쓰고 지워버리는 것. Model이 아닌 RedirectAttributes를 썼을 때...
        }
            return "redirect:/board/list";  // model에 담아두면 redirect할 때 url 뒤에 자동으로 key, value가 입력되는 효과
    }

    @GetMapping("/read")
    public String read(Integer bno, Integer page, Integer pageSize, Model m) {
        try {
            BoardDto boardDto = boardService.read(bno);
//            m.addAttribute("boardDto", boardDto); // 아래 문장과 동일
            m.addAttribute(boardDto); // 타입의 첫글자를 소문자로 한 것이 key가 된다

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board";
    }

    @GetMapping("/list")
    public String list(SearchCondition sc, Integer page, Integer pageSize, String option, String keyword, Model m, HttpServletRequest request) {
        if (!loginCheck(request)) {
            return "redirect:/login/login?toURL="+request.getRequestURL(); // 로그인을 안했으면 로그인 페이지로 이동
        }

        if(page == null) page = 1;
        if(pageSize == null) pageSize = 10;


        try {
            int totalCnt = boardService.getSearchResultCnt(sc);// getCount가 아닌, getSearchResultCnt
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);


//            Map map = new HashMap();
//            map.put("offset", (page - 1) * pageSize);
//            map.put("pageSize", pageSize);

            List<BoardDto> list = boardService.getSearchResultPage(sc); // getPage대신 getSearchResultPage
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
//            m.addAttribute("page", page);
//            m.addAttribute("pageSize", pageSize);
            m.addAttribute("option", option);
            m.addAttribute("keyword", keyword);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "boardList";
    }

    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션객체에 id가 있는지 확인, 있으면 true 반환
        return session.getAttribute("id") != null;
    }

}
