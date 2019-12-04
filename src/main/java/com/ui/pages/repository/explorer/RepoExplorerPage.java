package com.ui.pages.repository.explorer;

import java.io.IOException;

public class RepoExplorerPage {

    private RepoExplorerAct act;
    private RepoExplorerVerify verify;

    public RepoExplorerAct act() { return act; }
    public RepoExplorerVerify verify() { return verify; }

    private RepoExplorerPage(RepoExplorerAct act, RepoExplorerVerify verify) {
        this.act = act;
        this.verify = verify;
    }

    public static RepoExplorerPage getRepoExplorerPage() {
        return new RepoExplorerPage(new RepoExplorerAct(), new RepoExplorerVerify());
    }
}
