package com.ui.pages.repository.search;

public class SearchPage {

    SearchAct act;
    SearchVerify verify;

    public SearchAct act() { return act; }
    public SearchVerify verify() { return verify; }

    private SearchPage(SearchAct act, SearchVerify verify) {
        this.act = act;
        this.verify = verify;
    }

    public static SearchPage getSearchPage() {
        return new SearchPage(new SearchAct(), new SearchVerify());
    }

}
