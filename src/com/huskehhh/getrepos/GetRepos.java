package com.huskehhh.getrepos;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;

public class GetRepos {

    public static void main(String[] args) {
        RepositoryService service = new RepositoryService();
        try {
            for (Repository repo : service.getRepositories(args[0])) {
                String clone = repo.getCloneUrl();
                cloneRepo(clone);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void cloneRepo(String clone) {
        try {
            Process cloneRepo = Runtime.getRuntime().exec("git clone " + clone);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
