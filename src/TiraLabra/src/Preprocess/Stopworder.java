/*
a
about
above
after
again
against
all
am
an
and
any
are
aren't
as
at
be
because
been
before
being
below
between
both
but
by
can't
cannot
could
couldn't
did
didn't
do
does
doesn't
doing
don't
down
during
each
few
for
from
further
had
hadn't
has
hasn't
have
haven't
having
he
he'd
he'll
he's
her
here
here's
hers
herself
him
himself
his
how
how's
i
i'd
i'll
i'm
i've
if
in
into
is
isn't
it
it's
its
itself
let's
me
more
most
mustn't
my
myself
no
nor
not
of
off
on
once
only
or
other
ought
our
ours
 */
package Preprocess;

import java.util.HashSet;

/**
 *
 * @author jan
 */
public class Stopworder {
    HashSet<String> stopwordlist;

    public Stopworder() {
        this.stopwordlist = new HashSet();
        
    }
    // will use self made hashset in the end
    public boolean isItStop(String word) {
        return this.stopwordlist.contains(word);
    }
}