package com.jiehfut.dssmtransaction.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserService {

    /**
     * 用户买书
     * @param username
     * @param bookId
     * @param buyNum
     */
    void checkout(String username, Integer bookId, Integer buyNum) throws IOException;
}
