package com.jiehfut.dssmtransaction.service.impl;

import com.jiehfut.dssmtransaction.bean.Book;
import com.jiehfut.dssmtransaction.dao.AccountDao;
import com.jiehfut.dssmtransaction.dao.BookDao;
import com.jiehfut.dssmtransaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;

    @Override
    @Transactional
    @Transactional(timeout = 3) // 一旦超过约定时间的秒数，超时就会回滚
    @Transactional()
    public void checkout(String username, Integer bookId, Integer buyNum) {
        // 1.查询图书信息
        Book book = bookDao.getBookById(bookId);
        // 2.扣钱
        BigDecimal multiply = new BigDecimal(buyNum).multiply(book.getPrice());
        accountDao.updateByUsername(username, multiply);
        // 3.扣减库存
        bookDao.updateBook(bookId, buyNum);

        // 异常 测试事务是否回滚
        // int num = 10 / 0;
    }



    /**
     * 事务细节信息 *
     * 1.TransactionManager 控制事务的获取、提交、回滚
     * 2.该接口底层使用的是 JdbcTransactionManager
     * 3.事务原理是有一个（切面）进行拦截
     *      （1）事务管理器：TransactionManager 控制事务的获取、提交、回滚
     *      （2）事务拦截器（切面拦截）：class TransactionInterceptor extends TransactionAspectSupport 控制何时提交和回滚
     *          出现异常的时候就会回滚，正常执行就会提交
     *

     @Target({ElementType.TYPE, ElementType.METHOD})
     @Retention(RetentionPolicy.RUNTIME)
     @Inherited
     @Documented
     @Reflective
     public @interface Transactional {
         @AliasFor("transactionManager")
         String value() default "";

         @AliasFor("value")
         String transactionManager() default "";

         String[] label() default {};

         Propagation propagation() default Propagation.REQUIRED;
         传播行为

         Isolation isolation() default Isolation.DEFAULT;
         隔离级别

         int timeout() default TransactionDefinition.TIMEOUT_DEFAULT;
         控制事务超时时间 second

         String timeoutString() default "";


         boolean readOnly() default false;

         Class<? extends Throwable>[] rollbackFor() default {};

         String[] rollbackForClassName() default {};

         Class<? extends Throwable>[] noRollbackFor() default {};

         String[] noRollbackForClassName() default {};
     }



     public interface PlatformTransactionManager extends TransactionManager {
         控制事务的获取
         TransactionStatus getTransaction(@Nullable TransactionDefinition definition) throws TransactionException;
         控制事务提交
         void commit(TransactionStatus status) throws TransactionException;
         控制事务回滚
         void rollback(TransactionStatus status) throws TransactionException;
     }

     */




}
