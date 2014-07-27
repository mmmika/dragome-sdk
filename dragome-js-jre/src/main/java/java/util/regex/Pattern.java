package java.util.regex;

import com.dragome.commons.javascript.ScriptHelper;

public final class Pattern
{

	private String regex;

	/**
	 * Compiles the given regular expression into a pattern.
	 * @param regex The expression to be compiled
	 */
	public static Pattern compile(String regex)
	{
		Pattern pattern= new Pattern();
		pattern.regex= regex;
		return pattern;
	}

	/**
	 * Creates a matcher that will match the given input against this pattern.
	 */
	public Matcher matcher(CharSequence input)
	{
		return new Matcher(ScriptHelper.eval("new RegExp(this.$$$regex, 'g')", this), input);
	}

}