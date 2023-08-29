import JSHOP2.*;

class Operator0 extends Operator
{
	public Operator0()
	{
		super(new Predicate(0, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[0];

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[1];
		addIn[0] = new DelAddAtomic(new Predicate(0, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new PreconditionNil(1)).setComparator(null);
		p.reset();

		return p;
	}
}

class Operator1 extends Operator
{
	public Operator1()
	{
		super(new Predicate(1, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[1];
		delIn[0] = new DelAddAtomic(new Predicate(0, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[0];

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new PreconditionAtomic(new Predicate(0, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition0 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition0(Term[] unifier)
	{
		p = new Precondition[2];
		p[0] = new PreconditionAtomic(new Predicate(0, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionNegation(new PreconditionAtomic(new Predicate(0, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier), 2);
		b = new Term[2][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return null;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		return Term.merge(b, 2);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
	}
}

class Precondition1 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition1(Term[] unifier)
	{
		p = new Precondition[2];
		p[0] = new PreconditionAtomic(new Predicate(0, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[1] = new PreconditionNegation(new PreconditionAtomic(new Predicate(0, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier), 2);
		b = new Term[2][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return null;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		return Term.merge(b, 2);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
	}
}

class Method0 extends Method
{
	public Method0()
	{
		super(new Predicate(0, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[2];

		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)), false, true));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition0(unifier)).setComparator(null);
			break;
			case 1:
				p = (new Precondition1(unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method0Branch0";
			case 1: return "Method0Branch1";
			default: return null;
		}
	}
}

public class basic extends Domain
{
	public basic()
	{
		TermVariable.initialize(2);

		constants = new String[1];
		constants[0] = "have";

		compoundTasks = new String[1];
		compoundTasks[0] = "swap";

		primitiveTasks = new String[2];
		primitiveTasks[0] = "!pickup";
		primitiveTasks[1] = "!drop";

		methods = new Method[1][];

		methods[0] = new Method[1];
		methods[0][0] = new Method0();


		ops = new Operator[2][];

		ops[0] = new Operator[1];
		ops[0][0] = new Operator0();

		ops[1] = new Operator[1];
		ops[1][0] = new Operator1();

		axioms = new Axiom[1][];

		axioms[0] = new Axiom[0];

	}
}