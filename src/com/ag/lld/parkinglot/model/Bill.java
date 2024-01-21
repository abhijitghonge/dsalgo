package com.ag.lld.parkinglot.model;

import com.ag.lld.parkinglot.model.enums.BillStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Date exitTime;
    private Token token;
    private Gate generatedAt;
    private Operator generatedBy;
    private List<Payment> paymentList = new ArrayList<>();
    private Long totalAmount;
    private BillStatus billStatus;

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void addPayment(Payment payment) {
        this.paymentList.add(payment);
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
