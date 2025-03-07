import TomtelandJen.TomtelandJ;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class TomtelandJTest {

    TomtelandJ tl = new TomtelandJ();



    List<String> uTomten = Arrays.asList("Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten", "Glader",
            "Butter", "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen");
    List<String> uGlader = Arrays.asList("Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten");
    List<String> uButter = Arrays.asList("Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran",
            "Bladlusen");
    List<String> uTrötter = Arrays.asList("Dammråttan", "Skumtomten");
    List<String> uSkumtomten = Arrays.asList("Dammråttan");
    List<String> uRäven = Arrays.asList("Gråsuggan", "Myran", "Bladlusen");
    List<String> uMyran = Arrays.asList("Bladlusen");


    @Test
    public final void getUnderlingsBladlusenTestJ(){
        List<String> list = new ArrayList<>();
        List<String> underlings = tl.getUnderlingsJ("Bladlusen", list);
        assertEquals(underlings.size(), 0);
    }

    @Test
    public final void getUnderlingsTrögerTestJ(){
        List<String> list = new ArrayList<>();
        List<String> underlings = tl.getUnderlingsJ("Tröger", list);
        assertEquals(underlings.size(), 0);
    }

    @Test
    public final void getUnderlingsBlygerTestJ(){
        List<String> list = new ArrayList<>();
        List<String> underlings = tl.getUnderlingsJ("Blyger", list);
        assertEquals(underlings.size(), 0);
    }

    @Test
    public final void getUnderlingsDammråttanTestJ(){
        List<String> list = new ArrayList<>();
        List<String> underlings = tl.getUnderlingsJ("Dammråttan", list);
        assertEquals(underlings.size(), 0);
    }

    @Test
    public final void getUnderlingsGråsugganTestJ(){
        List<String> list = new ArrayList<>();
        List<String> underlings = tl.getUnderlingsJ("Gråsuggan", list);
        assertEquals(underlings.size(), 0);
    }

    @Test
    public final void getUnderlingsHarenTestJ(){
        List<String> list = new ArrayList<>();
        List<String> underlings = tl.getUnderlingsJ("Haren", list);
        assertEquals(underlings.size(), 0);
    }

    @Test
    public final void getUnderlingsNyckelpiganTestJ(){
        List<String> list = new ArrayList<>();
        List<String> underlings = tl.getUnderlingsJ("Nyckelpigan", list);
        assertEquals(underlings.size(), 0);
    }

    @Test
    public final void getUnderlingsRådjuretTestJ(){
        List<String> list = new ArrayList<>();
        List<String> underlings = tl.getUnderlingsJ("Rådjuret", list);
        assertEquals(underlings.size(), 0);
    }

    @Test
    public final void getUnderlingsMyranTestJ(){
        List<String> list = new ArrayList<>();
        List<String> underlings = tl.getUnderlingsJ("Myran", list);
        assertEquals(underlings.size(), uMyran.size());
        assertFalse(underlings.retainAll(uMyran));
    }

    @Test
    public final void getUnderlingsRävenTestJ(){
        List<String> list = new LinkedList<>();
        List<String> underlings = tl.getUnderlingsJ("Räven", list);
        assertEquals(underlings.size(), uRäven.size());
        assertFalse(underlings.retainAll(uRäven));
    }

    @Test
    public final void getUnderlingsSkumtomtenTestJ(){
        List<String> list = new LinkedList<>();
        List<String> underlings = tl.getUnderlingsJ("Skumtomten", list);
        assertEquals(underlings.size(), uSkumtomten.size());
        assertFalse(underlings.retainAll(uSkumtomten));
    }

    @Test
    public final void getUnderlingsTrötterTestJ(){
        List<String> list = new LinkedList<>();
        List<String> underlings = tl.getUnderlingsJ("Trötter", list);
        assertEquals(underlings.size(), uTrötter.size());
        assertFalse(underlings.retainAll(uTrötter));
    }


    @Test
    public final void getUnderlingsButterTestJ(){
        List<String> list = new LinkedList<>();
        List<String> underlings = tl.getUnderlingsJ("Butter", list);
        assertEquals(underlings.size(), uButter.size());
        assertFalse(underlings.retainAll(uButter));
    }

    @Test
    public final void getUnderlingsGladerTestJ(){
        List<String> list = new LinkedList<>();
        List<String> underlings = tl.getUnderlingsJ("Glader", list);
        assertEquals(underlings.size(), uGlader.size());
        assertFalse(underlings.retainAll(uGlader));
    }

    @Test
    public final void getUnderlingsTomtenTestJ(){
        List<String> list = new LinkedList<>();
        List<String> underlings = tl.getUnderlingsJ("Tomten", list);
        assertEquals(underlings.size(), uTomten.size());
        assertFalse(underlings.retainAll(uTomten));
    }

}
