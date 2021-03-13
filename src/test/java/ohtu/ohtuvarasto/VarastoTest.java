package ohtu.ohtuvarasto;

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
    /*
    @Test
    public void oma_testi_2() {
        //return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
        varasto.lisaaVarastoon(2);
        assertEquals("saldo = 2, vielä tilaa 8",varasto.toString());
    }
    */
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
        Varasto testi_varasto = new Varasto(0);
        assertEquals(0, testi_varasto);
    }
    
    @Test
    public void oma_testi_8() {
        Varasto testi_varasto = new Varasto(0,0);
        assertEquals(0, testi_varasto.getTilavuus());
        assertEquals(0, testi_varasto.getSaldo());
    }
    
    @Test
    public void oma_testi_9() {
       Varasto testi_Varasto = new Varasto(10, 2);
       assertEquals(10, testi_Varasto.getTilavuus());
        assertEquals(2, testi_Varasto.getSaldo());
    }
    
    @Test
    public void oma_testi_10() {
       Varasto testi_Varasto = new Varasto(10, -2);
       assertEquals(10, testi_Varasto.getTilavuus());
        assertEquals(0, testi_Varasto.getSaldo());
    }
    
    @Test
    public void oma_testi_11() {
       Varasto testi_Varasto = new Varasto(10, 10);
       assertEquals(10, testi_Varasto.getTilavuus());
       assertEquals(10, testi_Varasto.getSaldo());
    }
    
    @Test
    public void oma_testi_12() {
        varasto.lisaaVarastoon(2);
        varasto.otaVarastosta(3);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
 
}