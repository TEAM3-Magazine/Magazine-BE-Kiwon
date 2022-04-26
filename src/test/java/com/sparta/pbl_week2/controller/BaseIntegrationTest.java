package com.sparta.pbl_week2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@AutoConfigureMockMvc
@Transactional
@Disabled
public class BaseIntegrationTest  {
    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper mapper;
}
