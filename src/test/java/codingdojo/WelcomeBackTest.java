package codingdojo;

import static org.junit.Assert.*;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

public class WelcomeBackTest {

	@Test
	public void helloAgain() {
		ImmutableList<String> what = ImmutableList.<String>builder()
			.add("Old code is hard, but with")
			.add("Java8")
			.add("&")
			.add("Guava Libs")
			.add("we may survive this.")
			.add("To help us, we")
			.add("have")
			.add("MoreUnit Plugin")
			.add("and the")
			.add("Infinitest Plugin")
			.add("installed")
			.add("so there will be some")
			.add("fun")
			.build();
		
		String result=Joiner.on(" ").join(what.stream()
			.filter(x -> x.length() <5 && x.length()>1)
			.collect(Collectors.toList()));
		
		assertEquals("have fun",result);
	}
}
