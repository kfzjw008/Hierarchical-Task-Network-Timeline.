import JSHOP2.*;

class Precondition0 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition0(Term[] unifier)
	{
		p = new Precondition[7];
		p[0] = new PreconditionAtomic(new Predicate(0, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(1, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(1, 3, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(2, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(3, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[5] = new PreconditionAtomic(new Predicate(4, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(5, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		b = new Term[7][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
		p[4].bind(binding);
		p[5].bind(binding);
		p[6].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[6] = p[6].nextBinding();
		while (b[6] == null)
		{
			b[5] = p[5].nextBinding();
			while (b[5] == null)
			{
				b[4] = p[4].nextBinding();
				while (b[4] == null)
				{
					b[3] = p[3].nextBinding();
					while (b[3] == null)
					{
						b[2] = p[2].nextBinding();
						while (b[2] == null)
						{
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
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
							b[2] = p[2].nextBinding();
						}
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
						b[3] = p[3].nextBinding();
					}
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
					b[4] = p[4].nextBinding();
				}
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
				b[5] = p[5].nextBinding();
			}
			p[6].reset();
			p[6].bind(Term.merge(b, 6));
			b[6] = p[6].nextBinding();
		}

		return Term.merge(b, 7);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
				b[1] = p[1].nextBinding();
				while (b[1] == null)
				{
					b[0] = p[0].nextBinding();
					if (b[0] == null)
						return;
					p[1].reset();
					p[1].bind(b[0]);
					b[1] = p[1].nextBinding();
				}
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		p[4].bind(Term.merge(b, 4));
		b[4] = p[4].nextBinding();
		while (b[4] == null)
		{
			b[3] = p[3].nextBinding();
			while (b[3] == null)
			{
				b[2] = p[2].nextBinding();
				while (b[2] == null)
				{
					b[1] = p[1].nextBinding();
					while (b[1] == null)
					{
						b[0] = p[0].nextBinding();
						if (b[0] == null)
							return;
						p[1].reset();
						p[1].bind(b[0]);
						b[1] = p[1].nextBinding();
					}
					p[2].reset();
					p[2].bind(Term.merge(b, 2));
					b[2] = p[2].nextBinding();
				}
				p[3].reset();
				p[3].bind(Term.merge(b, 3));
				b[3] = p[3].nextBinding();
			}
			p[4].reset();
			p[4].bind(Term.merge(b, 4));
			b[4] = p[4].nextBinding();
		}

		p[5].bind(Term.merge(b, 5));
		b[5] = p[5].nextBinding();
		while (b[5] == null)
		{
			b[4] = p[4].nextBinding();
			while (b[4] == null)
			{
				b[3] = p[3].nextBinding();
				while (b[3] == null)
				{
					b[2] = p[2].nextBinding();
					while (b[2] == null)
					{
						b[1] = p[1].nextBinding();
						while (b[1] == null)
						{
							b[0] = p[0].nextBinding();
							if (b[0] == null)
								return;
							p[1].reset();
							p[1].bind(b[0]);
							b[1] = p[1].nextBinding();
						}
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
						b[2] = p[2].nextBinding();
					}
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
					b[3] = p[3].nextBinding();
				}
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
				b[4] = p[4].nextBinding();
			}
			p[5].reset();
			p[5].bind(Term.merge(b, 5));
			b[5] = p[5].nextBinding();
		}

		p[6].bind(Term.merge(b, 6));
	}
}

class Operator0 extends Operator
{
	public Operator0()
	{
		super(new Predicate(0, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[1];
		delIn[0] = new DelAddAtomic(new Predicate(4, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[1];
		addIn[0] = new DelAddAtomic(new Predicate(4, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition0(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition1 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition1(Term[] unifier)
	{
		p = new Precondition[8];
		p[0] = new PreconditionAtomic(new Predicate(0, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(6, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(1, 3, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(7, 3, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[5] = new PreconditionAtomic(new Predicate(8, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[6] = new PreconditionAtomic(new Predicate(9, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(10, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		b = new Term[8][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
		p[4].bind(binding);
		p[5].bind(binding);
		p[6].bind(binding);
		p[7].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[7] = p[7].nextBinding();
		while (b[7] == null)
		{
			b[6] = p[6].nextBinding();
			while (b[6] == null)
			{
				b[5] = p[5].nextBinding();
				while (b[5] == null)
				{
					b[4] = p[4].nextBinding();
					while (b[4] == null)
					{
						b[3] = p[3].nextBinding();
						while (b[3] == null)
						{
							b[2] = p[2].nextBinding();
							while (b[2] == null)
							{
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
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
								b[2] = p[2].nextBinding();
							}
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
							b[3] = p[3].nextBinding();
						}
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
						b[4] = p[4].nextBinding();
					}
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
					b[5] = p[5].nextBinding();
				}
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
				b[6] = p[6].nextBinding();
			}
			p[7].reset();
			p[7].bind(Term.merge(b, 7));
			b[7] = p[7].nextBinding();
		}

		return Term.merge(b, 8);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
				b[1] = p[1].nextBinding();
				while (b[1] == null)
				{
					b[0] = p[0].nextBinding();
					if (b[0] == null)
						return;
					p[1].reset();
					p[1].bind(b[0]);
					b[1] = p[1].nextBinding();
				}
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		p[4].bind(Term.merge(b, 4));
		b[4] = p[4].nextBinding();
		while (b[4] == null)
		{
			b[3] = p[3].nextBinding();
			while (b[3] == null)
			{
				b[2] = p[2].nextBinding();
				while (b[2] == null)
				{
					b[1] = p[1].nextBinding();
					while (b[1] == null)
					{
						b[0] = p[0].nextBinding();
						if (b[0] == null)
							return;
						p[1].reset();
						p[1].bind(b[0]);
						b[1] = p[1].nextBinding();
					}
					p[2].reset();
					p[2].bind(Term.merge(b, 2));
					b[2] = p[2].nextBinding();
				}
				p[3].reset();
				p[3].bind(Term.merge(b, 3));
				b[3] = p[3].nextBinding();
			}
			p[4].reset();
			p[4].bind(Term.merge(b, 4));
			b[4] = p[4].nextBinding();
		}

		p[5].bind(Term.merge(b, 5));
		b[5] = p[5].nextBinding();
		while (b[5] == null)
		{
			b[4] = p[4].nextBinding();
			while (b[4] == null)
			{
				b[3] = p[3].nextBinding();
				while (b[3] == null)
				{
					b[2] = p[2].nextBinding();
					while (b[2] == null)
					{
						b[1] = p[1].nextBinding();
						while (b[1] == null)
						{
							b[0] = p[0].nextBinding();
							if (b[0] == null)
								return;
							p[1].reset();
							p[1].bind(b[0]);
							b[1] = p[1].nextBinding();
						}
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
						b[2] = p[2].nextBinding();
					}
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
					b[3] = p[3].nextBinding();
				}
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
				b[4] = p[4].nextBinding();
			}
			p[5].reset();
			p[5].bind(Term.merge(b, 5));
			b[5] = p[5].nextBinding();
		}

		p[6].bind(Term.merge(b, 6));
		b[6] = p[6].nextBinding();
		while (b[6] == null)
		{
			b[5] = p[5].nextBinding();
			while (b[5] == null)
			{
				b[4] = p[4].nextBinding();
				while (b[4] == null)
				{
					b[3] = p[3].nextBinding();
					while (b[3] == null)
					{
						b[2] = p[2].nextBinding();
						while (b[2] == null)
						{
							b[1] = p[1].nextBinding();
							while (b[1] == null)
							{
								b[0] = p[0].nextBinding();
								if (b[0] == null)
									return;
								p[1].reset();
								p[1].bind(b[0]);
								b[1] = p[1].nextBinding();
							}
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
							b[2] = p[2].nextBinding();
						}
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
						b[3] = p[3].nextBinding();
					}
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
					b[4] = p[4].nextBinding();
				}
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
				b[5] = p[5].nextBinding();
			}
			p[6].reset();
			p[6].bind(Term.merge(b, 6));
			b[6] = p[6].nextBinding();
		}

		p[7].bind(Term.merge(b, 7));
	}
}

class Operator1 extends Operator
{
	public Operator1()
	{
		super(new Predicate(1, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[2];
		delIn[0] = new DelAddAtomic(new Predicate(10, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(7, 3, new TermList(TermVariable.getVariable(2), TermList.NIL)));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[2];
		addIn[0] = new DelAddAtomic(new Predicate(11, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(12, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition1(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition2 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition2(Term[] unifier)
	{
		p = new Precondition[8];
		p[0] = new PreconditionAtomic(new Predicate(0, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(6, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(1, 3, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(4, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(13, 3, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[5] = new PreconditionAtomic(new Predicate(14, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[6] = new PreconditionAtomic(new Predicate(9, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(10, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		b = new Term[8][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
		p[4].bind(binding);
		p[5].bind(binding);
		p[6].bind(binding);
		p[7].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[7] = p[7].nextBinding();
		while (b[7] == null)
		{
			b[6] = p[6].nextBinding();
			while (b[6] == null)
			{
				b[5] = p[5].nextBinding();
				while (b[5] == null)
				{
					b[4] = p[4].nextBinding();
					while (b[4] == null)
					{
						b[3] = p[3].nextBinding();
						while (b[3] == null)
						{
							b[2] = p[2].nextBinding();
							while (b[2] == null)
							{
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
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
								b[2] = p[2].nextBinding();
							}
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
							b[3] = p[3].nextBinding();
						}
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
						b[4] = p[4].nextBinding();
					}
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
					b[5] = p[5].nextBinding();
				}
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
				b[6] = p[6].nextBinding();
			}
			p[7].reset();
			p[7].bind(Term.merge(b, 7));
			b[7] = p[7].nextBinding();
		}

		return Term.merge(b, 8);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
				b[1] = p[1].nextBinding();
				while (b[1] == null)
				{
					b[0] = p[0].nextBinding();
					if (b[0] == null)
						return;
					p[1].reset();
					p[1].bind(b[0]);
					b[1] = p[1].nextBinding();
				}
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		p[4].bind(Term.merge(b, 4));
		b[4] = p[4].nextBinding();
		while (b[4] == null)
		{
			b[3] = p[3].nextBinding();
			while (b[3] == null)
			{
				b[2] = p[2].nextBinding();
				while (b[2] == null)
				{
					b[1] = p[1].nextBinding();
					while (b[1] == null)
					{
						b[0] = p[0].nextBinding();
						if (b[0] == null)
							return;
						p[1].reset();
						p[1].bind(b[0]);
						b[1] = p[1].nextBinding();
					}
					p[2].reset();
					p[2].bind(Term.merge(b, 2));
					b[2] = p[2].nextBinding();
				}
				p[3].reset();
				p[3].bind(Term.merge(b, 3));
				b[3] = p[3].nextBinding();
			}
			p[4].reset();
			p[4].bind(Term.merge(b, 4));
			b[4] = p[4].nextBinding();
		}

		p[5].bind(Term.merge(b, 5));
		b[5] = p[5].nextBinding();
		while (b[5] == null)
		{
			b[4] = p[4].nextBinding();
			while (b[4] == null)
			{
				b[3] = p[3].nextBinding();
				while (b[3] == null)
				{
					b[2] = p[2].nextBinding();
					while (b[2] == null)
					{
						b[1] = p[1].nextBinding();
						while (b[1] == null)
						{
							b[0] = p[0].nextBinding();
							if (b[0] == null)
								return;
							p[1].reset();
							p[1].bind(b[0]);
							b[1] = p[1].nextBinding();
						}
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
						b[2] = p[2].nextBinding();
					}
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
					b[3] = p[3].nextBinding();
				}
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
				b[4] = p[4].nextBinding();
			}
			p[5].reset();
			p[5].bind(Term.merge(b, 5));
			b[5] = p[5].nextBinding();
		}

		p[6].bind(Term.merge(b, 6));
		b[6] = p[6].nextBinding();
		while (b[6] == null)
		{
			b[5] = p[5].nextBinding();
			while (b[5] == null)
			{
				b[4] = p[4].nextBinding();
				while (b[4] == null)
				{
					b[3] = p[3].nextBinding();
					while (b[3] == null)
					{
						b[2] = p[2].nextBinding();
						while (b[2] == null)
						{
							b[1] = p[1].nextBinding();
							while (b[1] == null)
							{
								b[0] = p[0].nextBinding();
								if (b[0] == null)
									return;
								p[1].reset();
								p[1].bind(b[0]);
								b[1] = p[1].nextBinding();
							}
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
							b[2] = p[2].nextBinding();
						}
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
						b[3] = p[3].nextBinding();
					}
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
					b[4] = p[4].nextBinding();
				}
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
				b[5] = p[5].nextBinding();
			}
			p[6].reset();
			p[6].bind(Term.merge(b, 6));
			b[6] = p[6].nextBinding();
		}

		p[7].bind(Term.merge(b, 7));
	}
}

class Operator2 extends Operator
{
	public Operator2()
	{
		super(new Predicate(2, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[2];
		delIn[0] = new DelAddAtomic(new Predicate(10, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(13, 3, new TermList(TermVariable.getVariable(2), TermList.NIL)));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[2];
		addIn[0] = new DelAddAtomic(new Predicate(11, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(15, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition2(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition3 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition3(Term[] unifier)
	{
		p = new Precondition[4];
		p[0] = new PreconditionAtomic(new Predicate(0, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(6, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(9, 2, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(11, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		b = new Term[4][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
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
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		return Term.merge(b, 4);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
	}
}

class Operator3 extends Operator
{
	public Operator3()
	{
		super(new Predicate(3, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[1];
		delIn[0] = new DelAddAtomic(new Predicate(11, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[1];
		addIn[0] = new DelAddAtomic(new Predicate(10, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition3(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition4 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition4(Term[] unifier)
	{
		p = new Precondition[9];
		p[0] = new PreconditionAtomic(new Predicate(0, 4, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(16, 4, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(17, 4, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(1, 4, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(18, 4, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[5] = new PreconditionAtomic(new Predicate(19, 4, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(20, 4, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[8] = new PreconditionAtomic(new Predicate(21, 4, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		b = new Term[9][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
		p[4].bind(binding);
		p[5].bind(binding);
		p[6].bind(binding);
		p[7].bind(binding);
		p[8].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[8] = p[8].nextBinding();
		while (b[8] == null)
		{
			b[7] = p[7].nextBinding();
			while (b[7] == null)
			{
				b[6] = p[6].nextBinding();
				while (b[6] == null)
				{
					b[5] = p[5].nextBinding();
					while (b[5] == null)
					{
						b[4] = p[4].nextBinding();
						while (b[4] == null)
						{
							b[3] = p[3].nextBinding();
							while (b[3] == null)
							{
								b[2] = p[2].nextBinding();
								while (b[2] == null)
								{
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
									p[2].reset();
									p[2].bind(Term.merge(b, 2));
									b[2] = p[2].nextBinding();
								}
								p[3].reset();
								p[3].bind(Term.merge(b, 3));
								b[3] = p[3].nextBinding();
							}
							p[4].reset();
							p[4].bind(Term.merge(b, 4));
							b[4] = p[4].nextBinding();
						}
						p[5].reset();
						p[5].bind(Term.merge(b, 5));
						b[5] = p[5].nextBinding();
					}
					p[6].reset();
					p[6].bind(Term.merge(b, 6));
					b[6] = p[6].nextBinding();
				}
				p[7].reset();
				p[7].bind(Term.merge(b, 7));
				b[7] = p[7].nextBinding();
			}
			p[8].reset();
			p[8].bind(Term.merge(b, 8));
			b[8] = p[8].nextBinding();
		}

		return Term.merge(b, 9);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		p[8].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
				b[1] = p[1].nextBinding();
				while (b[1] == null)
				{
					b[0] = p[0].nextBinding();
					if (b[0] == null)
						return;
					p[1].reset();
					p[1].bind(b[0]);
					b[1] = p[1].nextBinding();
				}
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		p[4].bind(Term.merge(b, 4));
		b[4] = p[4].nextBinding();
		while (b[4] == null)
		{
			b[3] = p[3].nextBinding();
			while (b[3] == null)
			{
				b[2] = p[2].nextBinding();
				while (b[2] == null)
				{
					b[1] = p[1].nextBinding();
					while (b[1] == null)
					{
						b[0] = p[0].nextBinding();
						if (b[0] == null)
							return;
						p[1].reset();
						p[1].bind(b[0]);
						b[1] = p[1].nextBinding();
					}
					p[2].reset();
					p[2].bind(Term.merge(b, 2));
					b[2] = p[2].nextBinding();
				}
				p[3].reset();
				p[3].bind(Term.merge(b, 3));
				b[3] = p[3].nextBinding();
			}
			p[4].reset();
			p[4].bind(Term.merge(b, 4));
			b[4] = p[4].nextBinding();
		}

		p[5].bind(Term.merge(b, 5));
		b[5] = p[5].nextBinding();
		while (b[5] == null)
		{
			b[4] = p[4].nextBinding();
			while (b[4] == null)
			{
				b[3] = p[3].nextBinding();
				while (b[3] == null)
				{
					b[2] = p[2].nextBinding();
					while (b[2] == null)
					{
						b[1] = p[1].nextBinding();
						while (b[1] == null)
						{
							b[0] = p[0].nextBinding();
							if (b[0] == null)
								return;
							p[1].reset();
							p[1].bind(b[0]);
							b[1] = p[1].nextBinding();
						}
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
						b[2] = p[2].nextBinding();
					}
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
					b[3] = p[3].nextBinding();
				}
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
				b[4] = p[4].nextBinding();
			}
			p[5].reset();
			p[5].bind(Term.merge(b, 5));
			b[5] = p[5].nextBinding();
		}

		p[6].bind(Term.merge(b, 6));
		b[6] = p[6].nextBinding();
		while (b[6] == null)
		{
			b[5] = p[5].nextBinding();
			while (b[5] == null)
			{
				b[4] = p[4].nextBinding();
				while (b[4] == null)
				{
					b[3] = p[3].nextBinding();
					while (b[3] == null)
					{
						b[2] = p[2].nextBinding();
						while (b[2] == null)
						{
							b[1] = p[1].nextBinding();
							while (b[1] == null)
							{
								b[0] = p[0].nextBinding();
								if (b[0] == null)
									return;
								p[1].reset();
								p[1].bind(b[0]);
								b[1] = p[1].nextBinding();
							}
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
							b[2] = p[2].nextBinding();
						}
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
						b[3] = p[3].nextBinding();
					}
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
					b[4] = p[4].nextBinding();
				}
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
				b[5] = p[5].nextBinding();
			}
			p[6].reset();
			p[6].bind(Term.merge(b, 6));
			b[6] = p[6].nextBinding();
		}

		p[7].bind(Term.merge(b, 7));
		b[7] = p[7].nextBinding();
		while (b[7] == null)
		{
			b[6] = p[6].nextBinding();
			while (b[6] == null)
			{
				b[5] = p[5].nextBinding();
				while (b[5] == null)
				{
					b[4] = p[4].nextBinding();
					while (b[4] == null)
					{
						b[3] = p[3].nextBinding();
						while (b[3] == null)
						{
							b[2] = p[2].nextBinding();
							while (b[2] == null)
							{
								b[1] = p[1].nextBinding();
								while (b[1] == null)
								{
									b[0] = p[0].nextBinding();
									if (b[0] == null)
										return;
									p[1].reset();
									p[1].bind(b[0]);
									b[1] = p[1].nextBinding();
								}
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
								b[2] = p[2].nextBinding();
							}
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
							b[3] = p[3].nextBinding();
						}
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
						b[4] = p[4].nextBinding();
					}
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
					b[5] = p[5].nextBinding();
				}
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
				b[6] = p[6].nextBinding();
			}
			p[7].reset();
			p[7].bind(Term.merge(b, 7));
			b[7] = p[7].nextBinding();
		}

		p[8].bind(Term.merge(b, 8));
	}
}

class Operator4 extends Operator
{
	public Operator4()
	{
		super(new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[0];

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[1];
		addIn[0] = new DelAddAtomic(new Predicate(22, 4, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition4(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition5 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition5(Term[] unifier)
	{
		p = new Precondition[11];
		p[0] = new PreconditionAtomic(new Predicate(0, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(1, 5, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(17, 5, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(16, 5, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(23, 5, new TermList(TermVariable.getVariable(4), TermList.NIL)), unifier);
		p[5] = new PreconditionAtomic(new Predicate(22, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(21, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(18, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[8] = new PreconditionAtomic(new Predicate(24, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[9] = new PreconditionAtomic(new Predicate(20, 5, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[10] = new PreconditionAtomic(new Predicate(4, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		b = new Term[11][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
		p[4].bind(binding);
		p[5].bind(binding);
		p[6].bind(binding);
		p[7].bind(binding);
		p[8].bind(binding);
		p[9].bind(binding);
		p[10].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[10] = p[10].nextBinding();
		while (b[10] == null)
		{
			b[9] = p[9].nextBinding();
			while (b[9] == null)
			{
				b[8] = p[8].nextBinding();
				while (b[8] == null)
				{
					b[7] = p[7].nextBinding();
					while (b[7] == null)
					{
						b[6] = p[6].nextBinding();
						while (b[6] == null)
						{
							b[5] = p[5].nextBinding();
							while (b[5] == null)
							{
								b[4] = p[4].nextBinding();
								while (b[4] == null)
								{
									b[3] = p[3].nextBinding();
									while (b[3] == null)
									{
										b[2] = p[2].nextBinding();
										while (b[2] == null)
										{
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
											p[2].reset();
											p[2].bind(Term.merge(b, 2));
											b[2] = p[2].nextBinding();
										}
										p[3].reset();
										p[3].bind(Term.merge(b, 3));
										b[3] = p[3].nextBinding();
									}
									p[4].reset();
									p[4].bind(Term.merge(b, 4));
									b[4] = p[4].nextBinding();
								}
								p[5].reset();
								p[5].bind(Term.merge(b, 5));
								b[5] = p[5].nextBinding();
							}
							p[6].reset();
							p[6].bind(Term.merge(b, 6));
							b[6] = p[6].nextBinding();
						}
						p[7].reset();
						p[7].bind(Term.merge(b, 7));
						b[7] = p[7].nextBinding();
					}
					p[8].reset();
					p[8].bind(Term.merge(b, 8));
					b[8] = p[8].nextBinding();
				}
				p[9].reset();
				p[9].bind(Term.merge(b, 9));
				b[9] = p[9].nextBinding();
			}
			p[10].reset();
			p[10].bind(Term.merge(b, 10));
			b[10] = p[10].nextBinding();
		}

		return Term.merge(b, 11);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		p[8].reset();
		p[9].reset();
		p[10].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
				b[1] = p[1].nextBinding();
				while (b[1] == null)
				{
					b[0] = p[0].nextBinding();
					if (b[0] == null)
						return;
					p[1].reset();
					p[1].bind(b[0]);
					b[1] = p[1].nextBinding();
				}
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		p[4].bind(Term.merge(b, 4));
		b[4] = p[4].nextBinding();
		while (b[4] == null)
		{
			b[3] = p[3].nextBinding();
			while (b[3] == null)
			{
				b[2] = p[2].nextBinding();
				while (b[2] == null)
				{
					b[1] = p[1].nextBinding();
					while (b[1] == null)
					{
						b[0] = p[0].nextBinding();
						if (b[0] == null)
							return;
						p[1].reset();
						p[1].bind(b[0]);
						b[1] = p[1].nextBinding();
					}
					p[2].reset();
					p[2].bind(Term.merge(b, 2));
					b[2] = p[2].nextBinding();
				}
				p[3].reset();
				p[3].bind(Term.merge(b, 3));
				b[3] = p[3].nextBinding();
			}
			p[4].reset();
			p[4].bind(Term.merge(b, 4));
			b[4] = p[4].nextBinding();
		}

		p[5].bind(Term.merge(b, 5));
		b[5] = p[5].nextBinding();
		while (b[5] == null)
		{
			b[4] = p[4].nextBinding();
			while (b[4] == null)
			{
				b[3] = p[3].nextBinding();
				while (b[3] == null)
				{
					b[2] = p[2].nextBinding();
					while (b[2] == null)
					{
						b[1] = p[1].nextBinding();
						while (b[1] == null)
						{
							b[0] = p[0].nextBinding();
							if (b[0] == null)
								return;
							p[1].reset();
							p[1].bind(b[0]);
							b[1] = p[1].nextBinding();
						}
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
						b[2] = p[2].nextBinding();
					}
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
					b[3] = p[3].nextBinding();
				}
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
				b[4] = p[4].nextBinding();
			}
			p[5].reset();
			p[5].bind(Term.merge(b, 5));
			b[5] = p[5].nextBinding();
		}

		p[6].bind(Term.merge(b, 6));
		b[6] = p[6].nextBinding();
		while (b[6] == null)
		{
			b[5] = p[5].nextBinding();
			while (b[5] == null)
			{
				b[4] = p[4].nextBinding();
				while (b[4] == null)
				{
					b[3] = p[3].nextBinding();
					while (b[3] == null)
					{
						b[2] = p[2].nextBinding();
						while (b[2] == null)
						{
							b[1] = p[1].nextBinding();
							while (b[1] == null)
							{
								b[0] = p[0].nextBinding();
								if (b[0] == null)
									return;
								p[1].reset();
								p[1].bind(b[0]);
								b[1] = p[1].nextBinding();
							}
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
							b[2] = p[2].nextBinding();
						}
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
						b[3] = p[3].nextBinding();
					}
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
					b[4] = p[4].nextBinding();
				}
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
				b[5] = p[5].nextBinding();
			}
			p[6].reset();
			p[6].bind(Term.merge(b, 6));
			b[6] = p[6].nextBinding();
		}

		p[7].bind(Term.merge(b, 7));
		b[7] = p[7].nextBinding();
		while (b[7] == null)
		{
			b[6] = p[6].nextBinding();
			while (b[6] == null)
			{
				b[5] = p[5].nextBinding();
				while (b[5] == null)
				{
					b[4] = p[4].nextBinding();
					while (b[4] == null)
					{
						b[3] = p[3].nextBinding();
						while (b[3] == null)
						{
							b[2] = p[2].nextBinding();
							while (b[2] == null)
							{
								b[1] = p[1].nextBinding();
								while (b[1] == null)
								{
									b[0] = p[0].nextBinding();
									if (b[0] == null)
										return;
									p[1].reset();
									p[1].bind(b[0]);
									b[1] = p[1].nextBinding();
								}
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
								b[2] = p[2].nextBinding();
							}
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
							b[3] = p[3].nextBinding();
						}
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
						b[4] = p[4].nextBinding();
					}
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
					b[5] = p[5].nextBinding();
				}
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
				b[6] = p[6].nextBinding();
			}
			p[7].reset();
			p[7].bind(Term.merge(b, 7));
			b[7] = p[7].nextBinding();
		}

		p[8].bind(Term.merge(b, 8));
		b[8] = p[8].nextBinding();
		while (b[8] == null)
		{
			b[7] = p[7].nextBinding();
			while (b[7] == null)
			{
				b[6] = p[6].nextBinding();
				while (b[6] == null)
				{
					b[5] = p[5].nextBinding();
					while (b[5] == null)
					{
						b[4] = p[4].nextBinding();
						while (b[4] == null)
						{
							b[3] = p[3].nextBinding();
							while (b[3] == null)
							{
								b[2] = p[2].nextBinding();
								while (b[2] == null)
								{
									b[1] = p[1].nextBinding();
									while (b[1] == null)
									{
										b[0] = p[0].nextBinding();
										if (b[0] == null)
											return;
										p[1].reset();
										p[1].bind(b[0]);
										b[1] = p[1].nextBinding();
									}
									p[2].reset();
									p[2].bind(Term.merge(b, 2));
									b[2] = p[2].nextBinding();
								}
								p[3].reset();
								p[3].bind(Term.merge(b, 3));
								b[3] = p[3].nextBinding();
							}
							p[4].reset();
							p[4].bind(Term.merge(b, 4));
							b[4] = p[4].nextBinding();
						}
						p[5].reset();
						p[5].bind(Term.merge(b, 5));
						b[5] = p[5].nextBinding();
					}
					p[6].reset();
					p[6].bind(Term.merge(b, 6));
					b[6] = p[6].nextBinding();
				}
				p[7].reset();
				p[7].bind(Term.merge(b, 7));
				b[7] = p[7].nextBinding();
			}
			p[8].reset();
			p[8].bind(Term.merge(b, 8));
			b[8] = p[8].nextBinding();
		}

		p[9].bind(Term.merge(b, 9));
		b[9] = p[9].nextBinding();
		while (b[9] == null)
		{
			b[8] = p[8].nextBinding();
			while (b[8] == null)
			{
				b[7] = p[7].nextBinding();
				while (b[7] == null)
				{
					b[6] = p[6].nextBinding();
					while (b[6] == null)
					{
						b[5] = p[5].nextBinding();
						while (b[5] == null)
						{
							b[4] = p[4].nextBinding();
							while (b[4] == null)
							{
								b[3] = p[3].nextBinding();
								while (b[3] == null)
								{
									b[2] = p[2].nextBinding();
									while (b[2] == null)
									{
										b[1] = p[1].nextBinding();
										while (b[1] == null)
										{
											b[0] = p[0].nextBinding();
											if (b[0] == null)
												return;
											p[1].reset();
											p[1].bind(b[0]);
											b[1] = p[1].nextBinding();
										}
										p[2].reset();
										p[2].bind(Term.merge(b, 2));
										b[2] = p[2].nextBinding();
									}
									p[3].reset();
									p[3].bind(Term.merge(b, 3));
									b[3] = p[3].nextBinding();
								}
								p[4].reset();
								p[4].bind(Term.merge(b, 4));
								b[4] = p[4].nextBinding();
							}
							p[5].reset();
							p[5].bind(Term.merge(b, 5));
							b[5] = p[5].nextBinding();
						}
						p[6].reset();
						p[6].bind(Term.merge(b, 6));
						b[6] = p[6].nextBinding();
					}
					p[7].reset();
					p[7].bind(Term.merge(b, 7));
					b[7] = p[7].nextBinding();
				}
				p[8].reset();
				p[8].bind(Term.merge(b, 8));
				b[8] = p[8].nextBinding();
			}
			p[9].reset();
			p[9].bind(Term.merge(b, 9));
			b[9] = p[9].nextBinding();
		}

		p[10].bind(Term.merge(b, 10));
	}
}

class Operator5 extends Operator
{
	public Operator5()
	{
		super(new Predicate(5, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)))))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[1];
		delIn[0] = new DelAddAtomic(new Predicate(22, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(0), TermList.NIL))));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[1];
		addIn[0] = new DelAddAtomic(new Predicate(25, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(4), TermList.NIL)))));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition5(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition6 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition6(Term[] unifier)
	{
		p = new Precondition[11];
		p[0] = new PreconditionAtomic(new Predicate(0, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(26, 5, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(1, 5, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(1, 5, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(1, 5, new TermList(TermVariable.getVariable(4), TermList.NIL)), unifier);
		p[5] = new PreconditionAtomic(new Predicate(4, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(27, 5, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(12, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[8] = new PreconditionAtomic(new Predicate(5, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[9] = new PreconditionAtomic(new Predicate(3, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[10] = new PreconditionAtomic(new Predicate(28, 5, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		b = new Term[11][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
		p[4].bind(binding);
		p[5].bind(binding);
		p[6].bind(binding);
		p[7].bind(binding);
		p[8].bind(binding);
		p[9].bind(binding);
		p[10].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[10] = p[10].nextBinding();
		while (b[10] == null)
		{
			b[9] = p[9].nextBinding();
			while (b[9] == null)
			{
				b[8] = p[8].nextBinding();
				while (b[8] == null)
				{
					b[7] = p[7].nextBinding();
					while (b[7] == null)
					{
						b[6] = p[6].nextBinding();
						while (b[6] == null)
						{
							b[5] = p[5].nextBinding();
							while (b[5] == null)
							{
								b[4] = p[4].nextBinding();
								while (b[4] == null)
								{
									b[3] = p[3].nextBinding();
									while (b[3] == null)
									{
										b[2] = p[2].nextBinding();
										while (b[2] == null)
										{
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
											p[2].reset();
											p[2].bind(Term.merge(b, 2));
											b[2] = p[2].nextBinding();
										}
										p[3].reset();
										p[3].bind(Term.merge(b, 3));
										b[3] = p[3].nextBinding();
									}
									p[4].reset();
									p[4].bind(Term.merge(b, 4));
									b[4] = p[4].nextBinding();
								}
								p[5].reset();
								p[5].bind(Term.merge(b, 5));
								b[5] = p[5].nextBinding();
							}
							p[6].reset();
							p[6].bind(Term.merge(b, 6));
							b[6] = p[6].nextBinding();
						}
						p[7].reset();
						p[7].bind(Term.merge(b, 7));
						b[7] = p[7].nextBinding();
					}
					p[8].reset();
					p[8].bind(Term.merge(b, 8));
					b[8] = p[8].nextBinding();
				}
				p[9].reset();
				p[9].bind(Term.merge(b, 9));
				b[9] = p[9].nextBinding();
			}
			p[10].reset();
			p[10].bind(Term.merge(b, 10));
			b[10] = p[10].nextBinding();
		}

		return Term.merge(b, 11);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		p[8].reset();
		p[9].reset();
		p[10].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
				b[1] = p[1].nextBinding();
				while (b[1] == null)
				{
					b[0] = p[0].nextBinding();
					if (b[0] == null)
						return;
					p[1].reset();
					p[1].bind(b[0]);
					b[1] = p[1].nextBinding();
				}
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		p[4].bind(Term.merge(b, 4));
		b[4] = p[4].nextBinding();
		while (b[4] == null)
		{
			b[3] = p[3].nextBinding();
			while (b[3] == null)
			{
				b[2] = p[2].nextBinding();
				while (b[2] == null)
				{
					b[1] = p[1].nextBinding();
					while (b[1] == null)
					{
						b[0] = p[0].nextBinding();
						if (b[0] == null)
							return;
						p[1].reset();
						p[1].bind(b[0]);
						b[1] = p[1].nextBinding();
					}
					p[2].reset();
					p[2].bind(Term.merge(b, 2));
					b[2] = p[2].nextBinding();
				}
				p[3].reset();
				p[3].bind(Term.merge(b, 3));
				b[3] = p[3].nextBinding();
			}
			p[4].reset();
			p[4].bind(Term.merge(b, 4));
			b[4] = p[4].nextBinding();
		}

		p[5].bind(Term.merge(b, 5));
		b[5] = p[5].nextBinding();
		while (b[5] == null)
		{
			b[4] = p[4].nextBinding();
			while (b[4] == null)
			{
				b[3] = p[3].nextBinding();
				while (b[3] == null)
				{
					b[2] = p[2].nextBinding();
					while (b[2] == null)
					{
						b[1] = p[1].nextBinding();
						while (b[1] == null)
						{
							b[0] = p[0].nextBinding();
							if (b[0] == null)
								return;
							p[1].reset();
							p[1].bind(b[0]);
							b[1] = p[1].nextBinding();
						}
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
						b[2] = p[2].nextBinding();
					}
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
					b[3] = p[3].nextBinding();
				}
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
				b[4] = p[4].nextBinding();
			}
			p[5].reset();
			p[5].bind(Term.merge(b, 5));
			b[5] = p[5].nextBinding();
		}

		p[6].bind(Term.merge(b, 6));
		b[6] = p[6].nextBinding();
		while (b[6] == null)
		{
			b[5] = p[5].nextBinding();
			while (b[5] == null)
			{
				b[4] = p[4].nextBinding();
				while (b[4] == null)
				{
					b[3] = p[3].nextBinding();
					while (b[3] == null)
					{
						b[2] = p[2].nextBinding();
						while (b[2] == null)
						{
							b[1] = p[1].nextBinding();
							while (b[1] == null)
							{
								b[0] = p[0].nextBinding();
								if (b[0] == null)
									return;
								p[1].reset();
								p[1].bind(b[0]);
								b[1] = p[1].nextBinding();
							}
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
							b[2] = p[2].nextBinding();
						}
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
						b[3] = p[3].nextBinding();
					}
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
					b[4] = p[4].nextBinding();
				}
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
				b[5] = p[5].nextBinding();
			}
			p[6].reset();
			p[6].bind(Term.merge(b, 6));
			b[6] = p[6].nextBinding();
		}

		p[7].bind(Term.merge(b, 7));
		b[7] = p[7].nextBinding();
		while (b[7] == null)
		{
			b[6] = p[6].nextBinding();
			while (b[6] == null)
			{
				b[5] = p[5].nextBinding();
				while (b[5] == null)
				{
					b[4] = p[4].nextBinding();
					while (b[4] == null)
					{
						b[3] = p[3].nextBinding();
						while (b[3] == null)
						{
							b[2] = p[2].nextBinding();
							while (b[2] == null)
							{
								b[1] = p[1].nextBinding();
								while (b[1] == null)
								{
									b[0] = p[0].nextBinding();
									if (b[0] == null)
										return;
									p[1].reset();
									p[1].bind(b[0]);
									b[1] = p[1].nextBinding();
								}
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
								b[2] = p[2].nextBinding();
							}
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
							b[3] = p[3].nextBinding();
						}
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
						b[4] = p[4].nextBinding();
					}
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
					b[5] = p[5].nextBinding();
				}
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
				b[6] = p[6].nextBinding();
			}
			p[7].reset();
			p[7].bind(Term.merge(b, 7));
			b[7] = p[7].nextBinding();
		}

		p[8].bind(Term.merge(b, 8));
		b[8] = p[8].nextBinding();
		while (b[8] == null)
		{
			b[7] = p[7].nextBinding();
			while (b[7] == null)
			{
				b[6] = p[6].nextBinding();
				while (b[6] == null)
				{
					b[5] = p[5].nextBinding();
					while (b[5] == null)
					{
						b[4] = p[4].nextBinding();
						while (b[4] == null)
						{
							b[3] = p[3].nextBinding();
							while (b[3] == null)
							{
								b[2] = p[2].nextBinding();
								while (b[2] == null)
								{
									b[1] = p[1].nextBinding();
									while (b[1] == null)
									{
										b[0] = p[0].nextBinding();
										if (b[0] == null)
											return;
										p[1].reset();
										p[1].bind(b[0]);
										b[1] = p[1].nextBinding();
									}
									p[2].reset();
									p[2].bind(Term.merge(b, 2));
									b[2] = p[2].nextBinding();
								}
								p[3].reset();
								p[3].bind(Term.merge(b, 3));
								b[3] = p[3].nextBinding();
							}
							p[4].reset();
							p[4].bind(Term.merge(b, 4));
							b[4] = p[4].nextBinding();
						}
						p[5].reset();
						p[5].bind(Term.merge(b, 5));
						b[5] = p[5].nextBinding();
					}
					p[6].reset();
					p[6].bind(Term.merge(b, 6));
					b[6] = p[6].nextBinding();
				}
				p[7].reset();
				p[7].bind(Term.merge(b, 7));
				b[7] = p[7].nextBinding();
			}
			p[8].reset();
			p[8].bind(Term.merge(b, 8));
			b[8] = p[8].nextBinding();
		}

		p[9].bind(Term.merge(b, 9));
		b[9] = p[9].nextBinding();
		while (b[9] == null)
		{
			b[8] = p[8].nextBinding();
			while (b[8] == null)
			{
				b[7] = p[7].nextBinding();
				while (b[7] == null)
				{
					b[6] = p[6].nextBinding();
					while (b[6] == null)
					{
						b[5] = p[5].nextBinding();
						while (b[5] == null)
						{
							b[4] = p[4].nextBinding();
							while (b[4] == null)
							{
								b[3] = p[3].nextBinding();
								while (b[3] == null)
								{
									b[2] = p[2].nextBinding();
									while (b[2] == null)
									{
										b[1] = p[1].nextBinding();
										while (b[1] == null)
										{
											b[0] = p[0].nextBinding();
											if (b[0] == null)
												return;
											p[1].reset();
											p[1].bind(b[0]);
											b[1] = p[1].nextBinding();
										}
										p[2].reset();
										p[2].bind(Term.merge(b, 2));
										b[2] = p[2].nextBinding();
									}
									p[3].reset();
									p[3].bind(Term.merge(b, 3));
									b[3] = p[3].nextBinding();
								}
								p[4].reset();
								p[4].bind(Term.merge(b, 4));
								b[4] = p[4].nextBinding();
							}
							p[5].reset();
							p[5].bind(Term.merge(b, 5));
							b[5] = p[5].nextBinding();
						}
						p[6].reset();
						p[6].bind(Term.merge(b, 6));
						b[6] = p[6].nextBinding();
					}
					p[7].reset();
					p[7].bind(Term.merge(b, 7));
					b[7] = p[7].nextBinding();
				}
				p[8].reset();
				p[8].bind(Term.merge(b, 8));
				b[8] = p[8].nextBinding();
			}
			p[9].reset();
			p[9].bind(Term.merge(b, 9));
			b[9] = p[9].nextBinding();
		}

		p[10].bind(Term.merge(b, 10));
	}
}

class Operator6 extends Operator
{
	public Operator6()
	{
		super(new Predicate(6, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)))))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[2];
		delIn[0] = new DelAddAtomic(new Predicate(3, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(28, 5, new TermList(TermVariable.getVariable(1), TermList.NIL)));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[3];
		addIn[0] = new DelAddAtomic(new Predicate(28, 5, new TermList(TermVariable.getVariable(1), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(29, 5, new TermList(TermVariable.getVariable(2), TermList.NIL)));
		addIn[2] = new DelAddAtomic(new Predicate(3, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition6(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition7 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition7(Term[] unifier)
	{
		p = new Precondition[11];
		p[0] = new PreconditionAtomic(new Predicate(0, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(26, 5, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(1, 5, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(1, 5, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(1, 5, new TermList(TermVariable.getVariable(4), TermList.NIL)), unifier);
		p[5] = new PreconditionAtomic(new Predicate(4, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[6] = new PreconditionAtomic(new Predicate(27, 5, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(15, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[8] = new PreconditionAtomic(new Predicate(5, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[9] = new PreconditionAtomic(new Predicate(3, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[10] = new PreconditionAtomic(new Predicate(28, 5, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		b = new Term[11][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
		p[4].bind(binding);
		p[5].bind(binding);
		p[6].bind(binding);
		p[7].bind(binding);
		p[8].bind(binding);
		p[9].bind(binding);
		p[10].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[10] = p[10].nextBinding();
		while (b[10] == null)
		{
			b[9] = p[9].nextBinding();
			while (b[9] == null)
			{
				b[8] = p[8].nextBinding();
				while (b[8] == null)
				{
					b[7] = p[7].nextBinding();
					while (b[7] == null)
					{
						b[6] = p[6].nextBinding();
						while (b[6] == null)
						{
							b[5] = p[5].nextBinding();
							while (b[5] == null)
							{
								b[4] = p[4].nextBinding();
								while (b[4] == null)
								{
									b[3] = p[3].nextBinding();
									while (b[3] == null)
									{
										b[2] = p[2].nextBinding();
										while (b[2] == null)
										{
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
											p[2].reset();
											p[2].bind(Term.merge(b, 2));
											b[2] = p[2].nextBinding();
										}
										p[3].reset();
										p[3].bind(Term.merge(b, 3));
										b[3] = p[3].nextBinding();
									}
									p[4].reset();
									p[4].bind(Term.merge(b, 4));
									b[4] = p[4].nextBinding();
								}
								p[5].reset();
								p[5].bind(Term.merge(b, 5));
								b[5] = p[5].nextBinding();
							}
							p[6].reset();
							p[6].bind(Term.merge(b, 6));
							b[6] = p[6].nextBinding();
						}
						p[7].reset();
						p[7].bind(Term.merge(b, 7));
						b[7] = p[7].nextBinding();
					}
					p[8].reset();
					p[8].bind(Term.merge(b, 8));
					b[8] = p[8].nextBinding();
				}
				p[9].reset();
				p[9].bind(Term.merge(b, 9));
				b[9] = p[9].nextBinding();
			}
			p[10].reset();
			p[10].bind(Term.merge(b, 10));
			b[10] = p[10].nextBinding();
		}

		return Term.merge(b, 11);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		p[8].reset();
		p[9].reset();
		p[10].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
				b[1] = p[1].nextBinding();
				while (b[1] == null)
				{
					b[0] = p[0].nextBinding();
					if (b[0] == null)
						return;
					p[1].reset();
					p[1].bind(b[0]);
					b[1] = p[1].nextBinding();
				}
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		p[4].bind(Term.merge(b, 4));
		b[4] = p[4].nextBinding();
		while (b[4] == null)
		{
			b[3] = p[3].nextBinding();
			while (b[3] == null)
			{
				b[2] = p[2].nextBinding();
				while (b[2] == null)
				{
					b[1] = p[1].nextBinding();
					while (b[1] == null)
					{
						b[0] = p[0].nextBinding();
						if (b[0] == null)
							return;
						p[1].reset();
						p[1].bind(b[0]);
						b[1] = p[1].nextBinding();
					}
					p[2].reset();
					p[2].bind(Term.merge(b, 2));
					b[2] = p[2].nextBinding();
				}
				p[3].reset();
				p[3].bind(Term.merge(b, 3));
				b[3] = p[3].nextBinding();
			}
			p[4].reset();
			p[4].bind(Term.merge(b, 4));
			b[4] = p[4].nextBinding();
		}

		p[5].bind(Term.merge(b, 5));
		b[5] = p[5].nextBinding();
		while (b[5] == null)
		{
			b[4] = p[4].nextBinding();
			while (b[4] == null)
			{
				b[3] = p[3].nextBinding();
				while (b[3] == null)
				{
					b[2] = p[2].nextBinding();
					while (b[2] == null)
					{
						b[1] = p[1].nextBinding();
						while (b[1] == null)
						{
							b[0] = p[0].nextBinding();
							if (b[0] == null)
								return;
							p[1].reset();
							p[1].bind(b[0]);
							b[1] = p[1].nextBinding();
						}
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
						b[2] = p[2].nextBinding();
					}
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
					b[3] = p[3].nextBinding();
				}
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
				b[4] = p[4].nextBinding();
			}
			p[5].reset();
			p[5].bind(Term.merge(b, 5));
			b[5] = p[5].nextBinding();
		}

		p[6].bind(Term.merge(b, 6));
		b[6] = p[6].nextBinding();
		while (b[6] == null)
		{
			b[5] = p[5].nextBinding();
			while (b[5] == null)
			{
				b[4] = p[4].nextBinding();
				while (b[4] == null)
				{
					b[3] = p[3].nextBinding();
					while (b[3] == null)
					{
						b[2] = p[2].nextBinding();
						while (b[2] == null)
						{
							b[1] = p[1].nextBinding();
							while (b[1] == null)
							{
								b[0] = p[0].nextBinding();
								if (b[0] == null)
									return;
								p[1].reset();
								p[1].bind(b[0]);
								b[1] = p[1].nextBinding();
							}
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
							b[2] = p[2].nextBinding();
						}
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
						b[3] = p[3].nextBinding();
					}
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
					b[4] = p[4].nextBinding();
				}
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
				b[5] = p[5].nextBinding();
			}
			p[6].reset();
			p[6].bind(Term.merge(b, 6));
			b[6] = p[6].nextBinding();
		}

		p[7].bind(Term.merge(b, 7));
		b[7] = p[7].nextBinding();
		while (b[7] == null)
		{
			b[6] = p[6].nextBinding();
			while (b[6] == null)
			{
				b[5] = p[5].nextBinding();
				while (b[5] == null)
				{
					b[4] = p[4].nextBinding();
					while (b[4] == null)
					{
						b[3] = p[3].nextBinding();
						while (b[3] == null)
						{
							b[2] = p[2].nextBinding();
							while (b[2] == null)
							{
								b[1] = p[1].nextBinding();
								while (b[1] == null)
								{
									b[0] = p[0].nextBinding();
									if (b[0] == null)
										return;
									p[1].reset();
									p[1].bind(b[0]);
									b[1] = p[1].nextBinding();
								}
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
								b[2] = p[2].nextBinding();
							}
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
							b[3] = p[3].nextBinding();
						}
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
						b[4] = p[4].nextBinding();
					}
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
					b[5] = p[5].nextBinding();
				}
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
				b[6] = p[6].nextBinding();
			}
			p[7].reset();
			p[7].bind(Term.merge(b, 7));
			b[7] = p[7].nextBinding();
		}

		p[8].bind(Term.merge(b, 8));
		b[8] = p[8].nextBinding();
		while (b[8] == null)
		{
			b[7] = p[7].nextBinding();
			while (b[7] == null)
			{
				b[6] = p[6].nextBinding();
				while (b[6] == null)
				{
					b[5] = p[5].nextBinding();
					while (b[5] == null)
					{
						b[4] = p[4].nextBinding();
						while (b[4] == null)
						{
							b[3] = p[3].nextBinding();
							while (b[3] == null)
							{
								b[2] = p[2].nextBinding();
								while (b[2] == null)
								{
									b[1] = p[1].nextBinding();
									while (b[1] == null)
									{
										b[0] = p[0].nextBinding();
										if (b[0] == null)
											return;
										p[1].reset();
										p[1].bind(b[0]);
										b[1] = p[1].nextBinding();
									}
									p[2].reset();
									p[2].bind(Term.merge(b, 2));
									b[2] = p[2].nextBinding();
								}
								p[3].reset();
								p[3].bind(Term.merge(b, 3));
								b[3] = p[3].nextBinding();
							}
							p[4].reset();
							p[4].bind(Term.merge(b, 4));
							b[4] = p[4].nextBinding();
						}
						p[5].reset();
						p[5].bind(Term.merge(b, 5));
						b[5] = p[5].nextBinding();
					}
					p[6].reset();
					p[6].bind(Term.merge(b, 6));
					b[6] = p[6].nextBinding();
				}
				p[7].reset();
				p[7].bind(Term.merge(b, 7));
				b[7] = p[7].nextBinding();
			}
			p[8].reset();
			p[8].bind(Term.merge(b, 8));
			b[8] = p[8].nextBinding();
		}

		p[9].bind(Term.merge(b, 9));
		b[9] = p[9].nextBinding();
		while (b[9] == null)
		{
			b[8] = p[8].nextBinding();
			while (b[8] == null)
			{
				b[7] = p[7].nextBinding();
				while (b[7] == null)
				{
					b[6] = p[6].nextBinding();
					while (b[6] == null)
					{
						b[5] = p[5].nextBinding();
						while (b[5] == null)
						{
							b[4] = p[4].nextBinding();
							while (b[4] == null)
							{
								b[3] = p[3].nextBinding();
								while (b[3] == null)
								{
									b[2] = p[2].nextBinding();
									while (b[2] == null)
									{
										b[1] = p[1].nextBinding();
										while (b[1] == null)
										{
											b[0] = p[0].nextBinding();
											if (b[0] == null)
												return;
											p[1].reset();
											p[1].bind(b[0]);
											b[1] = p[1].nextBinding();
										}
										p[2].reset();
										p[2].bind(Term.merge(b, 2));
										b[2] = p[2].nextBinding();
									}
									p[3].reset();
									p[3].bind(Term.merge(b, 3));
									b[3] = p[3].nextBinding();
								}
								p[4].reset();
								p[4].bind(Term.merge(b, 4));
								b[4] = p[4].nextBinding();
							}
							p[5].reset();
							p[5].bind(Term.merge(b, 5));
							b[5] = p[5].nextBinding();
						}
						p[6].reset();
						p[6].bind(Term.merge(b, 6));
						b[6] = p[6].nextBinding();
					}
					p[7].reset();
					p[7].bind(Term.merge(b, 7));
					b[7] = p[7].nextBinding();
				}
				p[8].reset();
				p[8].bind(Term.merge(b, 8));
				b[8] = p[8].nextBinding();
			}
			p[9].reset();
			p[9].bind(Term.merge(b, 9));
			b[9] = p[9].nextBinding();
		}

		p[10].bind(Term.merge(b, 10));
	}
}

class Operator7 extends Operator
{
	public Operator7()
	{
		super(new Predicate(7, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL)))))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[2];
		delIn[0] = new DelAddAtomic(new Predicate(3, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(28, 5, new TermList(TermVariable.getVariable(1), TermList.NIL)));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[3];
		addIn[0] = new DelAddAtomic(new Predicate(28, 5, new TermList(TermVariable.getVariable(1), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(30, 5, new TermList(TermVariable.getVariable(2), TermList.NIL)));
		addIn[2] = new DelAddAtomic(new Predicate(3, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition7(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Precondition8 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition8(Term[] unifier)
	{
		p = new Precondition[12];
		p[0] = new PreconditionAtomic(new Predicate(0, 6, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(26, 6, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(17, 6, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(23, 6, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[4] = new PreconditionAtomic(new Predicate(1, 6, new TermList(TermVariable.getVariable(4), TermList.NIL)), unifier);
		p[5] = new PreconditionAtomic(new Predicate(1, 6, new TermList(TermVariable.getVariable(5), TermList.NIL)), unifier);
		p[6] = new PreconditionAtomic(new Predicate(4, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[7] = new PreconditionAtomic(new Predicate(27, 6, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[8] = new PreconditionAtomic(new Predicate(25, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);
		p[9] = new PreconditionAtomic(new Predicate(5, 6, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(5), TermList.NIL))), unifier);
		p[10] = new PreconditionAtomic(new Predicate(3, 6, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[11] = new PreconditionAtomic(new Predicate(28, 6, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		b = new Term[12][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
		p[4].bind(binding);
		p[5].bind(binding);
		p[6].bind(binding);
		p[7].bind(binding);
		p[8].bind(binding);
		p[9].bind(binding);
		p[10].bind(binding);
		p[11].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[11] = p[11].nextBinding();
		while (b[11] == null)
		{
			b[10] = p[10].nextBinding();
			while (b[10] == null)
			{
				b[9] = p[9].nextBinding();
				while (b[9] == null)
				{
					b[8] = p[8].nextBinding();
					while (b[8] == null)
					{
						b[7] = p[7].nextBinding();
						while (b[7] == null)
						{
							b[6] = p[6].nextBinding();
							while (b[6] == null)
							{
								b[5] = p[5].nextBinding();
								while (b[5] == null)
								{
									b[4] = p[4].nextBinding();
									while (b[4] == null)
									{
										b[3] = p[3].nextBinding();
										while (b[3] == null)
										{
											b[2] = p[2].nextBinding();
											while (b[2] == null)
											{
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
												p[2].reset();
												p[2].bind(Term.merge(b, 2));
												b[2] = p[2].nextBinding();
											}
											p[3].reset();
											p[3].bind(Term.merge(b, 3));
											b[3] = p[3].nextBinding();
										}
										p[4].reset();
										p[4].bind(Term.merge(b, 4));
										b[4] = p[4].nextBinding();
									}
									p[5].reset();
									p[5].bind(Term.merge(b, 5));
									b[5] = p[5].nextBinding();
								}
								p[6].reset();
								p[6].bind(Term.merge(b, 6));
								b[6] = p[6].nextBinding();
							}
							p[7].reset();
							p[7].bind(Term.merge(b, 7));
							b[7] = p[7].nextBinding();
						}
						p[8].reset();
						p[8].bind(Term.merge(b, 8));
						b[8] = p[8].nextBinding();
					}
					p[9].reset();
					p[9].bind(Term.merge(b, 9));
					b[9] = p[9].nextBinding();
				}
				p[10].reset();
				p[10].bind(Term.merge(b, 10));
				b[10] = p[10].nextBinding();
			}
			p[11].reset();
			p[11].bind(Term.merge(b, 11));
			b[11] = p[11].nextBinding();
		}

		return Term.merge(b, 12);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		p[7].reset();
		p[8].reset();
		p[9].reset();
		p[10].reset();
		p[11].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
				b[1] = p[1].nextBinding();
				while (b[1] == null)
				{
					b[0] = p[0].nextBinding();
					if (b[0] == null)
						return;
					p[1].reset();
					p[1].bind(b[0]);
					b[1] = p[1].nextBinding();
				}
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		p[4].bind(Term.merge(b, 4));
		b[4] = p[4].nextBinding();
		while (b[4] == null)
		{
			b[3] = p[3].nextBinding();
			while (b[3] == null)
			{
				b[2] = p[2].nextBinding();
				while (b[2] == null)
				{
					b[1] = p[1].nextBinding();
					while (b[1] == null)
					{
						b[0] = p[0].nextBinding();
						if (b[0] == null)
							return;
						p[1].reset();
						p[1].bind(b[0]);
						b[1] = p[1].nextBinding();
					}
					p[2].reset();
					p[2].bind(Term.merge(b, 2));
					b[2] = p[2].nextBinding();
				}
				p[3].reset();
				p[3].bind(Term.merge(b, 3));
				b[3] = p[3].nextBinding();
			}
			p[4].reset();
			p[4].bind(Term.merge(b, 4));
			b[4] = p[4].nextBinding();
		}

		p[5].bind(Term.merge(b, 5));
		b[5] = p[5].nextBinding();
		while (b[5] == null)
		{
			b[4] = p[4].nextBinding();
			while (b[4] == null)
			{
				b[3] = p[3].nextBinding();
				while (b[3] == null)
				{
					b[2] = p[2].nextBinding();
					while (b[2] == null)
					{
						b[1] = p[1].nextBinding();
						while (b[1] == null)
						{
							b[0] = p[0].nextBinding();
							if (b[0] == null)
								return;
							p[1].reset();
							p[1].bind(b[0]);
							b[1] = p[1].nextBinding();
						}
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
						b[2] = p[2].nextBinding();
					}
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
					b[3] = p[3].nextBinding();
				}
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
				b[4] = p[4].nextBinding();
			}
			p[5].reset();
			p[5].bind(Term.merge(b, 5));
			b[5] = p[5].nextBinding();
		}

		p[6].bind(Term.merge(b, 6));
		b[6] = p[6].nextBinding();
		while (b[6] == null)
		{
			b[5] = p[5].nextBinding();
			while (b[5] == null)
			{
				b[4] = p[4].nextBinding();
				while (b[4] == null)
				{
					b[3] = p[3].nextBinding();
					while (b[3] == null)
					{
						b[2] = p[2].nextBinding();
						while (b[2] == null)
						{
							b[1] = p[1].nextBinding();
							while (b[1] == null)
							{
								b[0] = p[0].nextBinding();
								if (b[0] == null)
									return;
								p[1].reset();
								p[1].bind(b[0]);
								b[1] = p[1].nextBinding();
							}
							p[2].reset();
							p[2].bind(Term.merge(b, 2));
							b[2] = p[2].nextBinding();
						}
						p[3].reset();
						p[3].bind(Term.merge(b, 3));
						b[3] = p[3].nextBinding();
					}
					p[4].reset();
					p[4].bind(Term.merge(b, 4));
					b[4] = p[4].nextBinding();
				}
				p[5].reset();
				p[5].bind(Term.merge(b, 5));
				b[5] = p[5].nextBinding();
			}
			p[6].reset();
			p[6].bind(Term.merge(b, 6));
			b[6] = p[6].nextBinding();
		}

		p[7].bind(Term.merge(b, 7));
		b[7] = p[7].nextBinding();
		while (b[7] == null)
		{
			b[6] = p[6].nextBinding();
			while (b[6] == null)
			{
				b[5] = p[5].nextBinding();
				while (b[5] == null)
				{
					b[4] = p[4].nextBinding();
					while (b[4] == null)
					{
						b[3] = p[3].nextBinding();
						while (b[3] == null)
						{
							b[2] = p[2].nextBinding();
							while (b[2] == null)
							{
								b[1] = p[1].nextBinding();
								while (b[1] == null)
								{
									b[0] = p[0].nextBinding();
									if (b[0] == null)
										return;
									p[1].reset();
									p[1].bind(b[0]);
									b[1] = p[1].nextBinding();
								}
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
								b[2] = p[2].nextBinding();
							}
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
							b[3] = p[3].nextBinding();
						}
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
						b[4] = p[4].nextBinding();
					}
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
					b[5] = p[5].nextBinding();
				}
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
				b[6] = p[6].nextBinding();
			}
			p[7].reset();
			p[7].bind(Term.merge(b, 7));
			b[7] = p[7].nextBinding();
		}

		p[8].bind(Term.merge(b, 8));
		b[8] = p[8].nextBinding();
		while (b[8] == null)
		{
			b[7] = p[7].nextBinding();
			while (b[7] == null)
			{
				b[6] = p[6].nextBinding();
				while (b[6] == null)
				{
					b[5] = p[5].nextBinding();
					while (b[5] == null)
					{
						b[4] = p[4].nextBinding();
						while (b[4] == null)
						{
							b[3] = p[3].nextBinding();
							while (b[3] == null)
							{
								b[2] = p[2].nextBinding();
								while (b[2] == null)
								{
									b[1] = p[1].nextBinding();
									while (b[1] == null)
									{
										b[0] = p[0].nextBinding();
										if (b[0] == null)
											return;
										p[1].reset();
										p[1].bind(b[0]);
										b[1] = p[1].nextBinding();
									}
									p[2].reset();
									p[2].bind(Term.merge(b, 2));
									b[2] = p[2].nextBinding();
								}
								p[3].reset();
								p[3].bind(Term.merge(b, 3));
								b[3] = p[3].nextBinding();
							}
							p[4].reset();
							p[4].bind(Term.merge(b, 4));
							b[4] = p[4].nextBinding();
						}
						p[5].reset();
						p[5].bind(Term.merge(b, 5));
						b[5] = p[5].nextBinding();
					}
					p[6].reset();
					p[6].bind(Term.merge(b, 6));
					b[6] = p[6].nextBinding();
				}
				p[7].reset();
				p[7].bind(Term.merge(b, 7));
				b[7] = p[7].nextBinding();
			}
			p[8].reset();
			p[8].bind(Term.merge(b, 8));
			b[8] = p[8].nextBinding();
		}

		p[9].bind(Term.merge(b, 9));
		b[9] = p[9].nextBinding();
		while (b[9] == null)
		{
			b[8] = p[8].nextBinding();
			while (b[8] == null)
			{
				b[7] = p[7].nextBinding();
				while (b[7] == null)
				{
					b[6] = p[6].nextBinding();
					while (b[6] == null)
					{
						b[5] = p[5].nextBinding();
						while (b[5] == null)
						{
							b[4] = p[4].nextBinding();
							while (b[4] == null)
							{
								b[3] = p[3].nextBinding();
								while (b[3] == null)
								{
									b[2] = p[2].nextBinding();
									while (b[2] == null)
									{
										b[1] = p[1].nextBinding();
										while (b[1] == null)
										{
											b[0] = p[0].nextBinding();
											if (b[0] == null)
												return;
											p[1].reset();
											p[1].bind(b[0]);
											b[1] = p[1].nextBinding();
										}
										p[2].reset();
										p[2].bind(Term.merge(b, 2));
										b[2] = p[2].nextBinding();
									}
									p[3].reset();
									p[3].bind(Term.merge(b, 3));
									b[3] = p[3].nextBinding();
								}
								p[4].reset();
								p[4].bind(Term.merge(b, 4));
								b[4] = p[4].nextBinding();
							}
							p[5].reset();
							p[5].bind(Term.merge(b, 5));
							b[5] = p[5].nextBinding();
						}
						p[6].reset();
						p[6].bind(Term.merge(b, 6));
						b[6] = p[6].nextBinding();
					}
					p[7].reset();
					p[7].bind(Term.merge(b, 7));
					b[7] = p[7].nextBinding();
				}
				p[8].reset();
				p[8].bind(Term.merge(b, 8));
				b[8] = p[8].nextBinding();
			}
			p[9].reset();
			p[9].bind(Term.merge(b, 9));
			b[9] = p[9].nextBinding();
		}

		p[10].bind(Term.merge(b, 10));
		b[10] = p[10].nextBinding();
		while (b[10] == null)
		{
			b[9] = p[9].nextBinding();
			while (b[9] == null)
			{
				b[8] = p[8].nextBinding();
				while (b[8] == null)
				{
					b[7] = p[7].nextBinding();
					while (b[7] == null)
					{
						b[6] = p[6].nextBinding();
						while (b[6] == null)
						{
							b[5] = p[5].nextBinding();
							while (b[5] == null)
							{
								b[4] = p[4].nextBinding();
								while (b[4] == null)
								{
									b[3] = p[3].nextBinding();
									while (b[3] == null)
									{
										b[2] = p[2].nextBinding();
										while (b[2] == null)
										{
											b[1] = p[1].nextBinding();
											while (b[1] == null)
											{
												b[0] = p[0].nextBinding();
												if (b[0] == null)
													return;
												p[1].reset();
												p[1].bind(b[0]);
												b[1] = p[1].nextBinding();
											}
											p[2].reset();
											p[2].bind(Term.merge(b, 2));
											b[2] = p[2].nextBinding();
										}
										p[3].reset();
										p[3].bind(Term.merge(b, 3));
										b[3] = p[3].nextBinding();
									}
									p[4].reset();
									p[4].bind(Term.merge(b, 4));
									b[4] = p[4].nextBinding();
								}
								p[5].reset();
								p[5].bind(Term.merge(b, 5));
								b[5] = p[5].nextBinding();
							}
							p[6].reset();
							p[6].bind(Term.merge(b, 6));
							b[6] = p[6].nextBinding();
						}
						p[7].reset();
						p[7].bind(Term.merge(b, 7));
						b[7] = p[7].nextBinding();
					}
					p[8].reset();
					p[8].bind(Term.merge(b, 8));
					b[8] = p[8].nextBinding();
				}
				p[9].reset();
				p[9].bind(Term.merge(b, 9));
				b[9] = p[9].nextBinding();
			}
			p[10].reset();
			p[10].bind(Term.merge(b, 10));
			b[10] = p[10].nextBinding();
		}

		p[11].bind(Term.merge(b, 11));
	}
}

class Operator8 extends Operator
{
	public Operator8()
	{
		super(new Predicate(8, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(5), TermList.NIL))))))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[2];
		delIn[0] = new DelAddAtomic(new Predicate(3, 6, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		delIn[1] = new DelAddAtomic(new Predicate(28, 6, new TermList(TermVariable.getVariable(1), TermList.NIL)));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[3];
		addIn[0] = new DelAddAtomic(new Predicate(28, 6, new TermList(TermVariable.getVariable(1), TermList.NIL)));
		addIn[1] = new DelAddAtomic(new Predicate(31, 6, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))));
		addIn[2] = new DelAddAtomic(new Predicate(3, 6, new TermList(TermVariable.getVariable(0), TermList.NIL)));

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition8(unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Operator9 extends Operator
{
	public Operator9()
	{
		super(new Predicate(9, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[0];

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[1];
		addIn[0] = new DelAddAtomic(new Predicate(32, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)));

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

class Operator10 extends Operator
{
	public Operator10()
	{
		super(new Predicate(10, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[1];
		delIn[0] = new DelAddAtomic(new Predicate(32, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[0];

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

class Method0 extends Method
{
	public Method0()
	{
		super(new Predicate(0, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[2];

		subsIn[0] = TaskList.empty;
		subsIn[1] = createTaskList1();

		setSubs(subsIn);
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(3, 2, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(10, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier)).setComparator(null);
			break;
			case 1:
				p = (new PreconditionNil(2)).setComparator(null);
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
			case 0: return "Case1";
			case 1: return "Case2";
			default: return null;
		}
	}
}

class Method1 extends Method
{
	public Method1()
	{
		super(new Predicate(1, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(3, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(9, 3, new TermList(TermVariable.getVariable(2), TermList.NIL)), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), TermList.NIL)))), false, false));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(10, 3, new TermList(TermVariable.getVariable(2), TermList.NIL)), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(4, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier)).setComparator(null);
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
			case 0: return "Method1Branch0";
			default: return null;
		}
	}
}

class Precondition9 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition9(Term[] unifier)
	{
		p = new Precondition[3];
		p[0] = new PreconditionAtomic(new Predicate(1, 4, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(2, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);
		p[2] = new PreconditionNegation(new PreconditionAtomic(new Predicate(32, 4, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier), 4);
		b = new Term[3][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
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
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		return Term.merge(b, 3);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
	}
}

class Method2 extends Method
{
	public Method2()
	{
		super(new Predicate(1, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))));
		TaskList[] subsIn = new TaskList[3];

		subsIn[0] = TaskList.empty;
		subsIn[1] = createTaskList1();
		subsIn[2] = createTaskList2();

		setSubs(subsIn);
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, true));

		return retVal;
	}

	TaskList createTaskList2()
	{
		TaskList retVal;

		retVal = new TaskList(4, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(3), TermList.NIL)))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(9, 4, new TermList(TermVariable.getVariable(3), TermList.NIL)), false, true));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(2), TermList.NIL)))), false, false));
		retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(10, 4, new TermList(TermVariable.getVariable(3), TermList.NIL)), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier)).setComparator(null);
			break;
			case 1:
				p = (new PreconditionAtomic(new Predicate(2, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), unifier)).setComparator(null);
			break;
			case 2:
				p = (new Precondition9(unifier)).setComparator(null);
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
			case 0: return "Case1";
			case 1: return "Case2";
			case 2: return "Case3";
			default: return null;
		}
	}
}

class Precondition10 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition10(Term[] unifier)
	{
		p = new Precondition[3];
		p[0] = new PreconditionAtomic(new Predicate(26, 5, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(27, 5, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(5, 5, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		b = new Term[3][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
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
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		return Term.merge(b, 3);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
	}
}

class Method3 extends Method
{
	public Method3()
	{
		super(new Predicate(2, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(6, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(3), TermList.NIL)))))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition10(unifier)).setComparator(null);
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
			case 0: return "Method3Branch0";
			default: return null;
		}
	}
}

class Precondition11 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition11(Term[] unifier)
	{
		p = new Precondition[4];
		p[0] = new PreconditionAtomic(new Predicate(1, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(0, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(9, 3, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(8, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		b = new Term[4][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
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
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		return Term.merge(b, 4);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
	}
}

class Method4 extends Method
{
	public Method4()
	{
		super(new Predicate(3, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(4, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, false));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(0), TermList.NIL)))), false, true));
		retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(2, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition11(unifier)).setComparator(null);
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
			case 0: return "Method4Branch0";
			default: return null;
		}
	}
}

class Precondition12 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition12(Term[] unifier)
	{
		p = new Precondition[3];
		p[0] = new PreconditionAtomic(new Predicate(26, 5, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(27, 5, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(5, 5, new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
		b = new Term[3][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
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
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		return Term.merge(b, 3);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
	}
}

class Method5 extends Method
{
	public Method5()
	{
		super(new Predicate(4, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(7, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(3), TermList.NIL)))))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition12(unifier)).setComparator(null);
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
			case 0: return "Method5Branch0";
			default: return null;
		}
	}
}

class Precondition13 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition13(Term[] unifier)
	{
		p = new Precondition[4];
		p[0] = new PreconditionAtomic(new Predicate(1, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(0, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(14, 3, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier);
		p[3] = new PreconditionAtomic(new Predicate(9, 3, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		b = new Term[4][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
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
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		return Term.merge(b, 4);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
	}
}

class Method6 extends Method
{
	public Method6()
	{
		super(new Predicate(5, 3, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(4, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(1), TermList.NIL))), false, false));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(2, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(0), TermList.NIL)))), false, true));
		retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(4, 3, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(0), TermList.NIL))), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition13(unifier)).setComparator(null);
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
			case 0: return "Method6Branch0";
			default: return null;
		}
	}
}

class Precondition14 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition14(Term[] unifier)
	{
		p = new Precondition[3];
		p[0] = new PreconditionAtomic(new Predicate(26, 6, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(27, 6, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(5, 6, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		b = new Term[3][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
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
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		return Term.merge(b, 3);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
	}
}

class Method7 extends Method
{
	public Method7()
	{
		super(new Predicate(6, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(5), TermList.NIL))), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(8, 6, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(4), TermList.NIL))))))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition14(unifier)).setComparator(null);
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
			case 0: return "Method7Branch0";
			default: return null;
		}
	}
}

class Precondition15 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition15(Term[] unifier)
	{
		p = new Precondition[5];
		p[0] = new PreconditionAtomic(new Predicate(17, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier);
		p[1] = new PreconditionAtomic(new Predicate(18, 5, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(21, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[3] = new PreconditionAtomic(new Predicate(24, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier);
		p[4] = new PreconditionAtomic(new Predicate(20, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		b = new Term[5][];

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
		p[2].bind(binding);
		p[3].bind(binding);
		p[4].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		if (b[0] == null)
			return null;

		b[4] = p[4].nextBinding();
		while (b[4] == null)
		{
			b[3] = p[3].nextBinding();
			while (b[3] == null)
			{
				b[2] = p[2].nextBinding();
				while (b[2] == null)
				{
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
					p[2].reset();
					p[2].bind(Term.merge(b, 2));
					b[2] = p[2].nextBinding();
				}
				p[3].reset();
				p[3].bind(Term.merge(b, 3));
				b[3] = p[3].nextBinding();
			}
			p[4].reset();
			p[4].bind(Term.merge(b, 4));
			b[4] = p[4].nextBinding();
		}

		return Term.merge(b, 5);
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();

		b[0] = p[0].nextBinding();
		if (b[0] == null)
			return;

		p[1].bind(b[0]);
		b[1] = p[1].nextBinding();
		while (b[1] == null)
		{
			b[0] = p[0].nextBinding();
			if (b[0] == null)
				return;
			p[1].reset();
			p[1].bind(b[0]);
			b[1] = p[1].nextBinding();
		}

		p[2].bind(Term.merge(b, 2));
		b[2] = p[2].nextBinding();
		while (b[2] == null)
		{
			b[1] = p[1].nextBinding();
			while (b[1] == null)
			{
				b[0] = p[0].nextBinding();
				if (b[0] == null)
					return;
				p[1].reset();
				p[1].bind(b[0]);
				b[1] = p[1].nextBinding();
			}
			p[2].reset();
			p[2].bind(Term.merge(b, 2));
			b[2] = p[2].nextBinding();
		}

		p[3].bind(Term.merge(b, 3));
		b[3] = p[3].nextBinding();
		while (b[3] == null)
		{
			b[2] = p[2].nextBinding();
			while (b[2] == null)
			{
				b[1] = p[1].nextBinding();
				while (b[1] == null)
				{
					b[0] = p[0].nextBinding();
					if (b[0] == null)
						return;
					p[1].reset();
					p[1].bind(b[0]);
					b[1] = p[1].nextBinding();
				}
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
				b[2] = p[2].nextBinding();
			}
			p[3].reset();
			p[3].bind(Term.merge(b, 3));
			b[3] = p[3].nextBinding();
		}

		p[4].bind(Term.merge(b, 4));
	}
}

class Method8 extends Method
{
	public Method8()
	{
		super(new Predicate(8, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(4, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(7, 5, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(1, 5, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(4), TermList.NIL))), false, false));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(5, 5, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(4), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(1), TermList.NIL)))))), false, true));
		retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(6, 5, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL)))), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition15(unifier)).setComparator(null);
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
			case 0: return "Method8Branch0";
			default: return null;
		}
	}
}

class Precondition16 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition16(Term[] unifier)
	{
		p = new Precondition[2];
		p[0] = new PreconditionAtomic(new Predicate(19, 4, new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL))), unifier);
		p[1] = new PreconditionAtomic(new Predicate(20, 4, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);
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

class Method9 extends Method
{
	public Method9()
	{
		super(new Predicate(7, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(2, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL))), false, false));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(4, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition16(unifier)).setComparator(null);
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
			case 0: return "Method9Branch0";
			default: return null;
		}
	}
}

public class basic extends Domain
{
	public basic()
	{
		TermVariable.initialize(6);

		constants = new String[33];
		constants[0] = "a003";
		constants[1] = "a005";
		constants[2] = "a00f";
		constants[3] = "a013";
		constants[4] = "a010";
		constants[5] = "a008";
		constants[6] = "a004";
		constants[7] = "a009";
		constants[8] = "a018";
		constants[9] = "a014";
		constants[10] = "a015";
		constants[11] = "full";
		constants[12] = "a01a";
		constants[13] = "a00a";
		constants[14] = "a016";
		constants[15] = "a01b";
		constants[16] = "a006";
		constants[17] = "a007";
		constants[18] = "a017";
		constants[19] = "a00d";
		constants[20] = "a00b";
		constants[21] = "a00e";
		constants[22] = "c009d";
		constants[23] = "a002";
		constants[24] = "a00c";
		constants[25] = "a01c";
		constants[26] = "a001";
		constants[27] = "a011";
		constants[28] = "a012";
		constants[29] = "a019";
		constants[30] = "a01d";
		constants[31] = "a01e";
		constants[32] = "a01f";

		compoundTasks = new String[9];
		compoundTasks[0] = "c001";
		compoundTasks[1] = "c002";
		compoundTasks[2] = "c003";
		compoundTasks[3] = "c004";
		compoundTasks[4] = "c005";
		compoundTasks[5] = "c006";
		compoundTasks[6] = "c007";
		compoundTasks[7] = "c009";
		compoundTasks[8] = "c008";

		primitiveTasks = new String[11];
		primitiveTasks[0] = "!e001";
		primitiveTasks[1] = "!e002";
		primitiveTasks[2] = "!e003";
		primitiveTasks[3] = "!e004";
		primitiveTasks[4] = "!e005";
		primitiveTasks[5] = "!e006";
		primitiveTasks[6] = "!e007";
		primitiveTasks[7] = "!e008";
		primitiveTasks[8] = "!e009";
		primitiveTasks[9] = "!e00a";
		primitiveTasks[10] = "!e00b";

		methods = new Method[9][];

		methods[0] = new Method[1];
		methods[0][0] = new Method0();

		methods[1] = new Method[2];
		methods[1][0] = new Method1();
		methods[1][1] = new Method2();

		methods[2] = new Method[1];
		methods[2][0] = new Method3();

		methods[3] = new Method[1];
		methods[3][0] = new Method4();

		methods[4] = new Method[1];
		methods[4][0] = new Method5();

		methods[5] = new Method[1];
		methods[5][0] = new Method6();

		methods[6] = new Method[1];
		methods[6][0] = new Method7();

		methods[7] = new Method[1];
		methods[7][0] = new Method9();

		methods[8] = new Method[1];
		methods[8][0] = new Method8();


		ops = new Operator[11][];

		ops[0] = new Operator[1];
		ops[0][0] = new Operator0();

		ops[1] = new Operator[1];
		ops[1][0] = new Operator1();

		ops[2] = new Operator[1];
		ops[2][0] = new Operator2();

		ops[3] = new Operator[1];
		ops[3][0] = new Operator3();

		ops[4] = new Operator[1];
		ops[4][0] = new Operator4();

		ops[5] = new Operator[1];
		ops[5][0] = new Operator5();

		ops[6] = new Operator[1];
		ops[6][0] = new Operator6();

		ops[7] = new Operator[1];
		ops[7][0] = new Operator7();

		ops[8] = new Operator[1];
		ops[8][0] = new Operator8();

		ops[9] = new Operator[1];
		ops[9][0] = new Operator9();

		ops[10] = new Operator[1];
		ops[10][0] = new Operator10();

		axioms = new Axiom[33][];

		axioms[0] = new Axiom[0];

		axioms[1] = new Axiom[0];

		axioms[2] = new Axiom[0];

		axioms[3] = new Axiom[0];

		axioms[4] = new Axiom[0];

		axioms[5] = new Axiom[0];

		axioms[6] = new Axiom[0];

		axioms[7] = new Axiom[0];

		axioms[8] = new Axiom[0];

		axioms[9] = new Axiom[0];

		axioms[10] = new Axiom[0];

		axioms[11] = new Axiom[0];

		axioms[12] = new Axiom[0];

		axioms[13] = new Axiom[0];

		axioms[14] = new Axiom[0];

		axioms[15] = new Axiom[0];

		axioms[16] = new Axiom[0];

		axioms[17] = new Axiom[0];

		axioms[18] = new Axiom[0];

		axioms[19] = new Axiom[0];

		axioms[20] = new Axiom[0];

		axioms[21] = new Axiom[0];

		axioms[22] = new Axiom[0];

		axioms[23] = new Axiom[0];

		axioms[24] = new Axiom[0];

		axioms[25] = new Axiom[0];

		axioms[26] = new Axiom[0];

		axioms[27] = new Axiom[0];

		axioms[28] = new Axiom[0];

		axioms[29] = new Axiom[0];

		axioms[30] = new Axiom[0];

		axioms[31] = new Axiom[0];

		axioms[32] = new Axiom[0];

	}
}