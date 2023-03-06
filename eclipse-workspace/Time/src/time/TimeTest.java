package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test@Disabled
	void testGetTotalSeconds() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetTotalSecondsGood()
	{
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}
	@Test
	public void testGetTotalSecondsBad()
	{
		assertThrows(StringIndexOutOfBoundsException.class,()-> {Time.getTotalSeconds("10:00");});
	}
	@Test
	void testGetTotalSecondsBoundary() {
		int seconds = Time.getTotalSeconds("00:59:59");
		assertTrue("The seconds were not calculated properly", seconds==3599);
	}
	
	@Test@Disabled
	void testGetSeconds() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetSecondsGood()
	{
		int seconds = Time.getSeconds("00:00:10");
		assertTrue("The seconds were not calculated properly", seconds==10);
	}
	@Test
	public void testGetSecondsBad()
	{
		assertThrows(NumberFormatException.class,()-> {Time.getSeconds("00:00:aa");});
	}
	@Test
	void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("00:00:59");
		assertTrue("The seconds were not calculated properly", seconds==59);
	}

	@Test@Disabled
	void testGetTotalMinutes() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetTotalMinutesBad()
	{
		assertThrows(NumberFormatException.class,()-> {Time.getTotalMinutes("00:x6:00");});
	}
	@ParameterizedTest
	@ValueSource(strings = { "00:59:00", "00:59:30","00:59:59" })
	void testGetTotalMinutes(String candidate) {
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes ==59);
	}

	@Test@Disabled
	void testGetTotalHours() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetTotalHoursBad()
	{
		assertThrows(NumberFormatException.class,()-> {Time.getTotalHours("5:00:59");});
	}
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15","05:59:59" })
	void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours ==5);
	}
	
	
	@Test
	public void getMilliseconds() {
		int miliseconds = Time.getMiliseconds("05:05:05:005");
		assertTrue("The minutes were not calculated properly", miliseconds == 5);
	}

	@Test
	public void getTotalMilliseconds() {
		int miliseconds = Time.getTotalMiliseconds("05:05:05:005");
		assertTrue("The minutes were not calculated properly", miliseconds == 18305005);
	}

	


}
