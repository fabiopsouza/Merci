package br.com.merci.domain.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageImplBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int paginationRange = 2;
	
	private int number;
    private int size;
    private int totalPages;
    private int numberOfElements;
    private long totalElements;
    private boolean first;
    private boolean last;
    private List<T> content;
    private Sort sort;
    
    private int startAt;
    private int endAt;
    
	public PageImplBean() {
		//Default constructor
	}

	public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

	public int getStartAt() {
		
		if(number <= paginationRange + 1) //inicio
			startAt = 1;
		else if(number >= totalPages - (paginationRange + 1)) //meio
			startAt = totalPages - ((2 * paginationRange) + 1); 
		else //fim
			startAt = number - paginationRange;
		
		return startAt;
	}

	public void setStartAt(int startAt){
		this.startAt = startAt;
	}
	
	public int getEndAt() {
		
		if(number <= paginationRange + 1) //inicio
			endAt = (2 * paginationRange) + 1;
		else if(number >= totalPages - (paginationRange + 1)) //meio
			endAt = totalPages;
		else //fim
			endAt = number + paginationRange;
		
		return endAt;
	}

	public void setEndAt(int endAt){
		this.startAt = endAt;
	}
	
}
