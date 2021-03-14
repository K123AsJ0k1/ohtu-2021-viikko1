package ohtu.ohtuvarasto;

import static java.time.Clock.system;
import java.io.*;
import static java.time.Clock.system;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_1() {
        varasto.lisaaVarastoon(2);
        varasto.otaVarastosta(2);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_2() {
        //return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
        assertEquals("saldo = 0.0, vielä tilaa 10.0",varasto.toString());
    }
    
    @Test
    public void oma_testi_3() {
        varasto.lisaaVarastoon(11);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_4() {
        varasto.lisaaVarastoon(-1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_5() {
        varasto.lisaaVarastoon(2);
        varasto.otaVarastosta(-2);
        assertEquals(2, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_6() {
        varasto.lisaaVarastoon(2);
        varasto.otaVarastosta(2);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_7() {
        varasto.lisaaVarastoon(2);
        varasto.otaVarastosta(3);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_8() {
        Varasto testi_varasto = new Varasto(0);
        assertEquals(0.0, testi_varasto.getTilavuus(),vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_9() {
        Varasto testi_varasto = new Varasto(10,5);
        assertEquals(5, testi_varasto.getSaldo(),vertailuTarkkuus);
        assertEquals(10, testi_varasto.getTilavuus(),vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_10() {
        Varasto testi_varasto = new Varasto(0,-1);
        assertEquals(0, testi_varasto.getSaldo(),vertailuTarkkuus);
        assertEquals(0, testi_varasto.getTilavuus(),vertailuTarkkuus);
    }
    
    @Test
    public void oma_testi_11() {
        Varasto testi_varasto = new Varasto(10,12);
        //Hajoitetaan ensimm�inen, alkuper�inen on 10
        assertEquals(9, testi_varasto.getSaldo(),vertailuTarkkuus);
        assertEquals(10, testi_varasto.getTilavuus(),vertailuTarkkuus);
    }
    
    
 
}