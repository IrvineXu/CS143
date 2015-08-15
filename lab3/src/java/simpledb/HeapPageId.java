package simpledb;

/** Unique identifier for HeapPage objects. */
public class HeapPageId implements PageId {

    private int _tableID;
    private int _pageNum;
    /**
     * Constructor. Create a page id structure for a specific page of a
     * specific table.
     *
     * @param tableId The table that is being referenced
     * @param pgNo The page number in that table.
     */
    public HeapPageId(int tableId, int pgNo) {
        // some code goes here
        // DONE
        _tableID = tableId;
        _pageNum = pgNo;
    }

    /** @return the table associated with this PageId */
    public int getTableId() {
        // some code goes here
        // DONE
        return _tableID;
    }

    /**
     * @return the page number in the table getTableId() associated with
     *   this PageId
     */
    public int pageNumber() {
        // some code goes here
        // DONE
        return _pageNum;
    }

    /**
     * @return a hash code for this page, represented by the concatenation of
     *   the table number and the page number (needed if a PageId is used as a
     *   key in a hash table in the BufferPool, for example.)
     * @see BufferPool
     */
    public int hashCode() {
        // some code goes here
        // DONE
	return (("" + _tableID) + ("" + _pageNum)).hashCode();
    }

    /**
     * Compares one PageId to another.
     *
     * @param o The object to compare against (must be a PageId)
     * @return true if the objects are equal (e.g., page numbers and table
     *   ids are the same)
     */
    public boolean equals(Object o) {
        // some code goes here
        // DONE
        
        // Sanity check
        if (o == null)
	    return false;
        
        if (!(o instanceof HeapPageId))
	    return false;
	    
        // Convert object o into a heapPageID
        HeapPageId hp = (HeapPageId)o;
        
        // compare TableID and pageNum
        if (_tableID == hp.getTableId() && _pageNum == hp.pageNumber())
	    return true;
        
        return false;
    }

    /**
     *  Return a representation of this object as an array of
     *  integers, for writing to disk.  Size of returned array must contain
     *  number of integers that corresponds to number of args to one of the
     *  constructors.
     */
    public int[] serialize() {
        int data[] = new int[2];

        data[0] = getTableId();
        data[1] = pageNumber();

        return data;
    }

}