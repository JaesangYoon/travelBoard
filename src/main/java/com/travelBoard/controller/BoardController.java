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

    @GetMapping("/write") // boardList���� �Խù� ��ư
    public String write(Model m) {
        m.addAttribute("mode", "new");
        return "board"; // board.jsp�� �б�, ���� ��ο��� ����. �����϶��� mode=new.
    }

    @PostMapping("/write") // �Խù� ���
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
            // RedirectAttributes�� addFlashAttrubute()�� session�� �̿��ؼ� ��� �����ߴٰ� �ѹ� ���� ���������� ��. Model�� �ƴ� RedirectAttributes�� ���� ��...
        }
            return "redirect:/board/list";  // model�� ��Ƶθ� redirect�� �� url �ڿ� �ڵ����� key, value�� �ԷµǴ� ȿ��
    }

    @GetMapping("/read")
    public String read(Integer bno, Integer page, Integer pageSize, Model m) {
        try {
            BoardDto boardDto = boardService.read(bno);
//            m.addAttribute("boardDto", boardDto); // �Ʒ� ����� ����
            m.addAttribute(boardDto); // Ÿ���� ù���ڸ� �ҹ��ڷ� �� ���� key�� �ȴ�

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board";
    }

    @GetMapping("/list")
    public String list(SearchCondition sc, Integer page, Integer pageSize, String option, String keyword, Model m, HttpServletRequest request) {
        if (!loginCheck(request)) {
            return "redirect:/login/login?toURL="+request.getRequestURL(); // �α����� �������� �α��� �������� �̵�
        }

        if(page == null) page = 1;
        if(pageSize == null) pageSize = 10;


        try {
            int totalCnt = boardService.getSearchResultCnt(sc);// getCount�� �ƴ�, getSearchResultCnt
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);


//            Map map = new HashMap();
//            map.put("offset", (page - 1) * pageSize);
//            map.put("pageSize", pageSize);

            List<BoardDto> list = boardService.getSearchResultPage(sc); // getPage��� getSearchResultPage
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
        // 1. ������ ��
        HttpSession session = request.getSession();
        // 2. ���ǰ�ü�� id�� �ִ��� Ȯ��, ������ true ��ȯ
        return session.getAttribute("id") != null;
    }

}
