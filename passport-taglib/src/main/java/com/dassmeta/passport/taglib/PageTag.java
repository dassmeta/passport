package com.dassmeta.passport.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dassmeta.passport.util.Paginator;

/**
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年3月6日
 */
public class PageTag extends SimpleTagSupport {

	private Paginator paginator;

	private String formId;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		StringBuilder sb = new StringBuilder();
		sb.append("<script type='text/javascript'>");
		sb.append("function go(pageNum){");
		sb.append("var f = $('#" + formId + "');");
		sb.append("f.attr('action',f.attr('action') + '?currentPage=' + pageNum);");
		sb.append(" f.submit();");
		sb.append(" }");
		sb.append(" </script>");
		sb.append("<ul class='pager pager-loose pager-pills '>");
		sb.append("<li class='previous'><a href='javascript:go(" + paginator.getPreviousPage() + ");'>«</a></li>");
		for (int i = 1; i <= paginator.getPages(); i++) {
			if (paginator.getPage() == i) {
				sb.append("<li class='active'>");
			} else {
				sb.append("<li>");
			}
			sb.append("<a href='javascript:go(" + i + ");'>" + i + "</a></li>");
		}
		sb.append("<li class='next'><a href='javascript:go(" + paginator.getNextPage() + ");'>»</a></li>");
		out.write(sb.toString());

	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

}
