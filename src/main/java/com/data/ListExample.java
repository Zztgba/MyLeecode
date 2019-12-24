package com.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
@Author zhongzaitao
@Date 2019-9-18 16:53
/
/
*
An ordered collection (also known as a <i>sequence</i>).  The user of this interface has precise control over where in the list each element is inserted.  The user can access elements by their integer index (position in the list), and search for elements in the list.

Unlike sets, lists typically allow duplicate elements.  More formally,lists typically allow pairs of elements "e1" and "e2" such that "e1.equals(e2)", and they typically allow multiplenull elements if they allow null elements at all.  It is not inconceivable that someone might wish to implement a list that prohibits duplicates, by throwing runtime exceptions when the user attempts to insert them, but we expect this usage to be rare.

The "List" interface places additional stipulations, beyond those specified in the "Collection" interface, on the contracts of the "iterator", "add", "remove", "equals", and "hashCode" methods.  Declarations for other inherited methods are also included here for convenience.

The "List" interface provides four methods for positional (indexed) access to list elements.  Lists (like Java arrays) are zero based.  Note that these operations may execute in time proportional to the index value for some implementations (the "LinkedList" class, for example). Thus, iterating over the elements in a list is typically preferable to indexing through it if the caller does not know the implementation.

The "List" interface provides a special iterator, called a "ListIterator", that allows element insertion and replacement, and bidirectional access in addition to the normal operations that the "Iterator" interface provides.  A method is provided to obtain a list iterator that starts at a specified position in the list.

The "List" interface provides two methods to search for a specified object.  From a performance standpoint, these methods should be used with caution.  In many implementations they will perform costly linear searches.

The "List" interface provides two methods to efficiently insert and remove multiple elements at an arbitrary point in the list.

Note: While it is permissible for lists to contain themselves as elements,extreme caution is advised: the "equals" and "hashCode" methods are no longer well defined on such a list.

Some list implementations have restrictions on the elements that they may contain.  For example, some implementations prohibit null elements,and some have restrictions on the types of their elements.  Attempting to add an ineligible element throws an unchecked exception, typically "NullPointerException" or "ClassCastException".  Attempting to query the presence of an ineligible element may throw an exception, or it may simply return false; some implementations will exhibit the former behavior and some will exhibit the latter.  More generally, attempting an operation on an ineligible element whose completion would not result in the insertion of an ineligible element into the list may throw an exception or it may succeed, at the option of the implementation.
Such exceptions are marked as "optional" in the specification for this interface.

Increases the capacity of this <tt>ArrayList</tt> instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
*/
//
//This interface is a member of the
//<a href="{@docRoot}/../technotes/guides/collections/index.html">
//Java Collections Framework</a>.
//
//@param <E> the type of elements in this list
//
//@author  Josh Bloch
//@author  Neal Gafter
//@see Collection
//@see Set
//@see ArrayList
//@see LinkedList
//@see Vector
//@see Arrays#asList(Object[])
//@see Collections#nCopies(int, Object)
//@see Collections#EMPTY_LIST
// @see AbstractList
// @see AbstractSequentialList
// @since 1.2
public class ListExample {
    public static void main(String[] args) {
        List a = new ArrayList();
        a.toArray();
    }
}
