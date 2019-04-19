package com.pelican.app.controller;

import com.pelican.app.client.BelgiumClient;
import com.pelican.app.client.EstoniaClient;
import com.pelican.app.client.LithuaniaClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by cetin on 4/19/2019.
 */
public class PelicanControllerTest {
    @Mock
    EstoniaClient estoniaClient;
    @Mock
    LithuaniaClient lithuaniaClient;
    @Mock
    BelgiumClient belgiumClient;

    @Before
    public void setUp() {

        Mockito.when(estoniaClient.translate("Hello"))
                .thenReturn("tere");
        Mockito.when(lithuaniaClient.translate("Hello"))
                .thenReturn("Labas");
        Mockito.when(belgiumClient.translate("Hello"))
                .thenReturn("Bonjour");
    }

    @Test
    public void translate() throws Exception {
        assertEquals("tere", estoniaClient.translate("Hello"));
        assertEquals("Labas", lithuaniaClient.translate("Hello"));
        assertEquals("Bonjour", belgiumClient.translate("Hello"));
    }

}