package com.emoji.wiki;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultSet implements Iterable<SearchResult> {
    private List<SearchResult> search;

    class ResultSetIterator implements Iterator<SearchResult> {
        private int index = 0;
        private ResultSet collection;

        public ResultSetIterator(ResultSet collection) {
            this.collection = collection;
        }

        @Override
        public boolean hasNext() {
            return index < collection.size();
        }

        @Override
        public SearchResult next() {
            SearchResult object;
            try {
                object = collection.get(index);
            } catch (ArrayIndexOutOfBoundsException exp) {
                throw new NoSuchElementException();
            }
            index++;
            return object;
        }
    }

    public ResultSet() {
        search = new ArrayList<>();
    }

    public void addSearchResult(SearchResult obj) {
        search.add(obj);
    }

    public boolean isEmpty() {
        return search.size() == 0;
    }

    public int size() {
        return search.size();
    }

    public SearchResult get(int index) {
        return search.get(index);
    }

    @Override
    public Iterator<SearchResult> iterator() {
        return new ResultSetIterator(this);
    }
}
