package com.ugamsol.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.*;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "ugamsol/components/page"
)

public class ResourceType extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        final ResourceResolver resourceResolver = request.getResourceResolver();
        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/ugamsol/us/en");
        List<Object> children = new ArrayList<>();
        Iterator<Page> allpages = page.listChildren();
        while (allpages.hasNext()) {
            Page childPage = allpages.next();
            String pageName;
            pageName =childPage.getTitle();
            children.add(pageName);
        }

        response.setContentType("text/html");
        response.getWriter().print(children);
    }
}
