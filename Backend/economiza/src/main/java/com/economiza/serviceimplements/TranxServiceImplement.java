package com.economiza.serviceimplements;

import com.economiza.entities.Tranx;
import com.economiza.repositories.ITranxRepository;
import com.economiza.serviceinterfaces.ITranxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TranxServiceImplement implements ITranxService {
    @Autowired
    private ITranxRepository txR;
    @Override
    public void insert(Tranx tranx) {
        txR.save(tranx);
    }

    @Override
    public void delete(int id) {
        txR.deleteById(id);
    }

    @Override
    public Tranx listId(int id) {
        return txR.findById(id).orElse(new Tranx());
    }

    @Override
    public List<Tranx> getTranxFromUser(int id) {
        return txR.getTranxFromUser(id);
    }

    @Override
    public List<Tranx> getTranxFromWallet(int id) {
        return txR.getTranxFromWallet(id);
    }

    @Override
    public List<Object[]> getIncomeFlowFromWalletByDay(Integer userid, Integer walletid, LocalDate initdate, LocalDate enddate) {
        if (walletid != null) {
            return txR.getIncomeFlowFromWalletByDay(userid, walletid, initdate, enddate);
        } else {
            return txR.getIncomeFlowFromUserByDay(userid,initdate,enddate);
        }
    }

    @Override
    public List<Object[]> getIncomeFlowFromWalletByWeek(Integer userid, Integer walletid, LocalDate initdate, LocalDate enddate) {
        if (walletid != null) {
            return txR.getIncomeFlowFromWalletByWeek(userid, walletid, initdate, enddate);
        } else {
            return txR.getIncomeFlowFromUserByWeek(userid,initdate,enddate);
        }
    }

    @Override
    public List<Object[]> getIncomeFlowFromWalletByMonth(Integer userid, Integer walletid, LocalDate initdate, LocalDate enddate) {
        if (walletid != null) {
            return txR.getIncomeFlowFromWalletByMonth(userid, walletid, initdate, enddate);
        } else {
            return txR.getIncomeFlowFromUserByMonth(userid,initdate,enddate);
        }
    }
}
