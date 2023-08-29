import JSHOP2.*;

public class problem
{
	private static String[] defineConstants()
	{
		String[] problemConstants = new String[2];

		problemConstants[0] = "kiwi";
		problemConstants[1] = "banjo";

		return problemConstants;
	}

	private static void createState0(State s)	{
		s.add(new Predicate(0, 0, new TermList(TermConstant.getConstant(1), TermList.NIL)));
	}

	public static void main(String[] args) throws InterruptedException
	{
		TermConstant.initialize(3);

		Domain d = new basic();

		d.setProblemConstants(defineConstants());

		State s = new State(1, d.getAxioms());

		JSHOP2.initialize(d, s);

		TaskList tl;
		Thread thread;

		createState0(s);

		tl = new TaskList(1, true);
		tl.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 0, new TermList(TermConstant.getConstant(2), new TermList(TermConstant.getConstant(1), TermList.NIL))), false, false));

		thread = new SolverThread(tl, 1);
		thread.start();
		while (thread.isAlive())
			Thread.sleep(500);
	}
}