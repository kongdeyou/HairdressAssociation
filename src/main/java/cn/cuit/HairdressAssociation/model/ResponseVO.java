package cn.cuit.HairdressAssociation.model;


public class ResponseVO<T> {
    private int status;
    private ErrorCode errCode;
    private String errMsg;
    private T data;

    public ResponseVO(T data) {
        status = 0;
        this.data = data;
    }

    public ResponseVO(ErrorCode errCode, String ErrMsg) {
        status = -1;
        this.errCode = errCode;
        this.errMsg = ErrMsg;
    }

    public int getStatus() {
        return status;
    }

    public ErrorCode getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrCode(ErrorCode errCode) {
        this.errCode = errCode;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
