package org.example.security.jwt;

import java.util.Date;

public class JwtData {

    private String sub;
    private Date iat;
    private Date exp;
    private Object header;
    private String signature;

    public JwtData(String sub, Date iat, Date exp, Object header, String signature) {
        this.sub = sub;
        this.iat = iat;
        this.exp = exp;
        this.header = header;
        this.signature = signature;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public Date getIat() {
        return iat;
    }

    public void setIat(Date iat) {
        this.iat = iat;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public Object getHeader() {
        return header;
    }

    public void setHeader(Object header) {
        this.header = header;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "\nJwtData{" +
                "\nsub='" + sub + '\'' +
                "\n, iat=" + iat +
                "\n, exp=" + exp +
                "\n, header=" + header +
                "\n, signature='" + signature + '\'' +
                "\n}";
    }
}
