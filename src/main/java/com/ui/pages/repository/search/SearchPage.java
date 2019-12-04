package com.ui.pages.repository.search;

import java.io.IOException;

public class SearchPage {

    SearchAct act;
    SearchVerify verify;

    public SearchAct act() { return act; }
    public SearchVerify verify() { return verify; }

    private SearchPage(SearchAct act, SearchVerify verify) {
        this.act = act;
        this.verify = verify;
    }

    public static SearchPage getSearchPage() throws IOException {
        return new SearchPage(new SearchAct(), new SearchVerify());
    }

}
