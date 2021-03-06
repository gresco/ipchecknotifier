package com.github.ipchecknotifier;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertyFileReader {
    private String mailfrom = null;
    private String mailto = null;
    private String subject = null;
    private CompositeConfiguration config = null;
    private String passwd = null;
    private String smtp = null;
    private String port = null;
    private boolean auth = true;
    private boolean tls = true;
    private String checkerURL = null;

    PropertyFileReader() throws ConfigurationException
    {
        this.config = new CompositeConfiguration();
        this.config.addConfiguration(
                new PropertiesConfiguration("ipchecker.properties"));

        this.mailfrom = config.getString("mail.from");
        this.mailto = config.getString("mail.to");
        this.subject = config.getString("mail.subject");
        this.passwd = config.getString("mail.password");
        this.smtp = config.getString("mail.smtp");
        this.port = config.getString("mail.port");
        this.auth = config.getBoolean("mail.auth");
        this.tls = config.getBoolean("mail.tls");
        this.checkerURL = config.getString("checker.url");
    }

    public String getCheckerURL()
    {
        return checkerURL;
    }

    public void setCheckerURL(String checkerURL)
    {
        this.checkerURL = checkerURL;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public boolean isTls() {
        return tls;
    }

    public void setTls(boolean tls) {
        this.tls = tls;
    }

    public boolean isConfigured()
    {
        if (config.getProperty("comment.me") != null)
            return false;

        return true;
    }

    public String getSmtp()
    {
        return smtp;
    }

    public void setSmtp(String smtp)
    {
        this.smtp = smtp;
    }

    public String getPort()
    {
        return port;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public String getPasswd()
    {
        return passwd;
    }

    public void getPasswd(String passwd)
    {
        this.passwd = passwd;
    }

    public String getMailfrom()
    {
        return mailfrom;
    }

    public void setMailfrom(String mailfrom)
    {
        this.mailfrom = mailfrom;
    }

    public String getMailto()
    {
        return mailto;
    }

    public void setMailto(String mailto)
    {
        this.mailto = mailto;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }
}