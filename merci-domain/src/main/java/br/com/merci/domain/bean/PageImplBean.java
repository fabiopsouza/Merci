package br.com.merci.domain.bean;

import org.springframework.data.domain.PageImpl;

public class PageImplBean<T> {

	private static final int paginationRange = 2;

	private PageImpl<T> impl;
    
    private int startAt;
    private int endAt;
    
	public PageImplBean(PageImpl<T> impl) {
		this.setImpl(impl);
	}

	public PageImpl<T> getImpl() {
		return impl;
	}

	public void setImpl(PageImpl<T> impl) {
		this.impl = impl;
	}
	
	public int getStartAt() {
		
		if(getImpl().getNumber() <= paginationRange + 1) //inicio
			startAt = 1;
		else if(getImpl().getNumber() >= getImpl().getTotalPages() - (paginationRange + 1)) //meio
			startAt = getImpl().getTotalPages() - ((2 * paginationRange) + 1); 
		else //fim
			startAt = getImpl().getNumber() - paginationRange;
		
		return startAt;
	}
	
	public int getEndAt() {
		
		if(getImpl().getNumber() <= paginationRange + 1) //inicio
			endAt = (2 * paginationRange) + 1;
		else if(getImpl().getNumber() >= getImpl().getTotalPages() - (paginationRange + 1)) //meio
			endAt = getImpl().getTotalPages();
		else //fim
			endAt = getImpl().getNumber() + paginationRange;
		
		return endAt;
	}

}
