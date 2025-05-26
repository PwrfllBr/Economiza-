package com.economiza.repositories;

import com.economiza.entities.Tranx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITranxRepository extends JpaRepository<Tranx, Integer> {
    @Query(value = "SELECT t.id, t.amount, t.note, t.trx_date, t.category_id, t.tag_id, w.id as wallet_id\n" +
            "FROM tranx t\n" +
            "JOIN wallet w ON t.wallet_id = w.id\n" +
            "WHERE w.app_user_id = 2", nativeQuery = true)
    public List<Tranx> getTranxFromUser(@Param("id") int id);

    @Query(value = "SELECT * FROM tranx t\n" +
            "WHERE t.wallet_id = :id", nativeQuery = true)
    public List<Tranx> getTranxFromWallet(@Param("id") int id);
    //Queries to get income flow by day
    ////to get from one wallet
    @Query(value = "SELECT DATE_TRUNC('day', t.trx_date) as time_period,\n" +
            "\tSUM(CASE WHEN c.type = true THEN t.amount ELSE 0 END) as total_income,\n" +
            "\tSUM(CASE WHEN c.type = false THEN t.amount ELSE 0 END) as total_expense\n" +
            "FROM tranx t\n" +
            "JOIN wallet w ON t.wallet_id = w.id\n" +
            "JOIN category c ON t.category_id = c.id\n" +
            "WHERE w.app_user_id = :userid\n" +
            "AND t.wallet_id = :walletid\n" +
            "AND t.trx_date BETWEEN :initdate AND :enddate\n" +
            "GROUP BY time_period", nativeQuery = true)
    public List<Object[]> getIncomeFlowFromWalletByDay(
            @Param("userid") int userid,
            @Param("walletid") int walletid,
            @Param("initdate") LocalDate initdate,
            @Param("enddate") LocalDate enddate);
    ////to get from all user wallets
    @Query(value = "SELECT DATE_TRUNC('day', t.trx_date) as time_period,\n" +
            "\tSUM(CASE WHEN c.type = true THEN t.amount ELSE 0 END) as total_income,\n" +
            "\tSUM(CASE WHEN c.type = false THEN t.amount ELSE 0 END) as total_expense\n" +
            "FROM tranx t\n" +
            "JOIN wallet w ON t.wallet_id = w.id\n" +
            "JOIN category c ON t.category_id = c.id\n" +
            "WHERE w.app_user_id = :userid\n" +
            "AND t.trx_date BETWEEN :initdate AND :enddate\n" +
            "GROUP BY time_period", nativeQuery = true)
    public List<Object[]> getIncomeFlowFromUserByDay(
            @Param("userid") int userid,
            @Param("initdate") LocalDate initdate,
            @Param("enddate") LocalDate enddate);

    //Queries to get income flow by week
    ////to get from one wallet
    @Query(value = "SELECT DATE_TRUNC('week', t.trx_date) as time_period,\n" +
            "\tSUM(CASE WHEN c.type = true THEN t.amount ELSE 0 END) as total_income,\n" +
            "\tSUM(CASE WHEN c.type = false THEN t.amount ELSE 0 END) as total_expense\n" +
            "FROM tranx t\n" +
            "JOIN wallet w ON t.wallet_id = w.id\n" +
            "JOIN category c ON t.category_id = c.id\n" +
            "WHERE w.app_user_id = :userid\n" +
            "AND t.wallet_id = :walletid\n" +
            "AND t.trx_date BETWEEN :initdate AND :enddate\n" +
            "GROUP BY time_period", nativeQuery = true)
    public List<Object[]> getIncomeFlowFromWalletByWeek(
            @Param("userid") int userid,
            @Param("walletid") int walletid,
            @Param("initdate") LocalDate initdate,
            @Param("enddate") LocalDate enddate);
    ////to get from all user wallets
    @Query(value = "SELECT DATE_TRUNC('week', t.trx_date) as time_period,\n" +
            "\tSUM(CASE WHEN c.type = true THEN t.amount ELSE 0 END) as total_income,\n" +
            "\tSUM(CASE WHEN c.type = false THEN t.amount ELSE 0 END) as total_expense\n" +
            "FROM tranx t\n" +
            "JOIN wallet w ON t.wallet_id = w.id\n" +
            "JOIN category c ON t.category_id = c.id\n" +
            "WHERE w.app_user_id = :userid\n" +
            "AND t.trx_date BETWEEN :initdate AND :enddate\n" +
            "GROUP BY time_period", nativeQuery = true)
    public List<Object[]> getIncomeFlowFromUserByWeek(
            @Param("userid") int userid,
            @Param("initdate") LocalDate initdate,
            @Param("enddate") LocalDate enddate);

    //Queries to get income flow by month
    ////to get from one wallet
    @Query(value = "SELECT DATE_TRUNC('month', t.trx_date) as time_period,\n" +
            "\tSUM(CASE WHEN c.type = true THEN t.amount ELSE 0 END) as total_income,\n" +
            "\tSUM(CASE WHEN c.type = false THEN t.amount ELSE 0 END) as total_expense\n" +
            "FROM tranx t\n" +
            "JOIN wallet w ON t.wallet_id = w.id\n" +
            "JOIN category c ON t.category_id = c.id\n" +
            "WHERE w.app_user_id = :userid\n" +
            "AND t.wallet_id = :walletid\n" +
            "AND t.trx_date BETWEEN :initdate AND :enddate\n" +
            "GROUP BY time_period", nativeQuery = true)
    public List<Object[]> getIncomeFlowFromWalletByMonth(
            @Param("userid") int userid,
            @Param("walletid") int walletid,
            @Param("initdate") LocalDate initdate,
            @Param("enddate") LocalDate enddate);
    ////to get from all user wallets
    @Query(value = "SELECT DATE_TRUNC('month', t.trx_date) as time_period,\n" +
            "\tSUM(CASE WHEN c.type = true THEN t.amount ELSE 0 END) as total_income,\n" +
            "\tSUM(CASE WHEN c.type = false THEN t.amount ELSE 0 END) as total_expense\n" +
            "FROM tranx t\n" +
            "JOIN wallet w ON t.wallet_id = w.id\n" +
            "JOIN category c ON t.category_id = c.id\n" +
            "WHERE w.app_user_id = :userid\n" +
            "AND t.trx_date BETWEEN :initdate AND :enddate\n" +
            "GROUP BY time_period", nativeQuery = true)
    public List<Object[]> getIncomeFlowFromUserByMonth(
            @Param("userid") int userid,
            @Param("initdate") LocalDate initdate,
            @Param("enddate") LocalDate enddate);
}
