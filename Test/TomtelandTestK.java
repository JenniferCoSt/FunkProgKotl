import KarinaTomteland.TomtelandK;
import org.junit.Test;

import java.util.Arrays;
import java.util.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TomtelandTestK {


	TomtelandK tl = new TomtelandK();


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
	public final void getUnderlingsBladlusenTest(){
		List<String> list = new ArrayList<>();
		List<String> underlings = tl.getUnderlingsK("Bladlusen", list);
		assertEquals(underlings.size(), 0);
	}

	@Test
	public final void getUnderlingsTrögerTest(){
		List<String> list = new ArrayList<>();
		List<String> underlings = tl.getUnderlingsK("Tröger", list);
		assertEquals(underlings.size(), 0);
	}

	@Test
	public final void getUnderlingsBlygerTest(){
		List<String> list = new ArrayList<>();
		List<String> underlings = tl.getUnderlingsK("Blyger", list);
		assertEquals(underlings.size(), 0);
	}

	@Test
	public final void getUnderlingsDammråttanTest(){
		List<String> list = new ArrayList<>();
		List<String> underlings = tl.getUnderlingsK("Dammråttan", list);
		assertEquals(underlings.size(), 0);
	}

	@Test
	public final void getUnderlingsGråsugganTest(){
		List<String> list = new ArrayList<>();
		List<String> underlings = tl.getUnderlingsK("Gråsuggan", list);
		assertEquals(underlings.size(), 0);
	}

	@Test
	public final void getUnderlingsHarenTest(){
		List<String> list = new ArrayList<>();
		List<String> underlings = tl.getUnderlingsK("Haren", list);
		assertEquals(underlings.size(), 0);
	}

	@Test
	public final void getUnderlingsNyckelpiganTest(){
		List<String> list = new ArrayList<>();
		List<String> underlings = tl.getUnderlingsK("Nyckelpigan", list);
		assertEquals(underlings.size(), 0);
	}

	@Test
	public final void getUnderlingsRådjuretTest(){
		List<String> list = new ArrayList<>();
		List<String> underlings = tl.getUnderlingsK("Rådjuret", list);
		assertEquals(underlings.size(), 0);
	}

	@Test
	public final void getUnderlingsMyranTest(){
		List<String> list = new ArrayList<>();
		List<String> underlings = tl.getUnderlingsK("Myran", list);
		assertEquals(underlings.size(), uMyran.size());
		assertFalse(underlings.retainAll(uMyran));
	}

	@Test
	public final void getUnderlingsRävenTest(){
		List<String> list = new LinkedList<>();
		List<String> underlings = tl.getUnderlingsK("Räven", list);
		assertEquals(underlings.size(), uRäven.size());
		assertFalse(underlings.retainAll(uRäven));
	}
}
