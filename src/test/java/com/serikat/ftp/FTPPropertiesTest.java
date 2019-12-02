package com.serikat.ftp;

import org.junit.Test;

import com.serikat.ftp.config.FTPProperties;

import static junit.framework.TestCase.assertTrue;

public class FTPPropertiesTest {

    @Test
    public void initShouldSetPortIfNotSet() {
        FTPProperties ftp = new FTPProperties();
        ftp.init();
        assertTrue(ftp.getPort() == 21);
    }

    @Test
    public void initShouldNotSetPortIfSet() {
        FTPProperties ftp = new FTPProperties();
        ftp.setPort(10);
        ftp.init();
        assertTrue(ftp.getPort() == 10);
    }
}
