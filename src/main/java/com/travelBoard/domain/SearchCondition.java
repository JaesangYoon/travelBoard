package com.travelBoard.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
    private Integer page = 1;
    private Integer pageSize = 10;
    //    private Integer offSet = 0;
    private String keyword = "";
    private String option = "";

    public SearchCondition() {}
    public SearchCondition(Integer page, Integer pageSize, String keyword, String option) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.option = option;
    }
    public String getQueryString(Integer page) {
        // 컨트롤러가 매개변수로 sc를 받는데 검색결과를 받고 다시 목록으로 돌아올 때 sc의 iv가 다 유지되어야 한다.
        // 그러기 위해 QueryString으로 iv값들을 다 줘야한다.수동으로 하기 번거롭기 때문에 URIComponents
        // ?page=1&pageSize=10&option=T&keyword="title <-- URIComponents가 이런식으로 만들어준다
        return UriComponentsBuilder.newInstance()
                .queryParam("page",     page)
                .queryParam("pageSize", pageSize)
                .queryParam("option",   option)
                .queryParam("keyword",  keyword)
                .build().toString();
    }

    public String getQueryString() {
        return getQueryString(page);
    }

    public Integer getOffset() {
        return (page - 1) * pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + getOffset() +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}
