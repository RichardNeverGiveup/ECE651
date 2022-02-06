package com.QuickBuy.common.pojo;


//StatusCode
public class StatusCode {

    public static final int OK = 20000; //success
    public static final int ERROR = 20001; //failed
    public static final int LOGINERROR = 20002; //log in error
    public static final int ACCESSERROR = 20003; //No access authority
    public static final int REMOTEERROR = 20004; //fail to call remotely
    public static final int REPERROR = 20005; //repeat operation
    public static final int NOTFOUNDERROR = 20006; //Not found error
}
