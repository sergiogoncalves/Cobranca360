/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.util;

import br.com.helenamax.cobranca.controller.UsuarioSessaoCtr;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 005712431
 */
@WebFilter(filterName = "FiltroGeral", urlPatterns = {"/*"})
public class FiltroGeral implements Filter {

    // @Inject
    // UsuarioSessaoBean usuarioSessaoBean;
    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    public FiltroGeral() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        String requestPath = ((HttpServletRequest) request).getRequestURI().toLowerCase();

        if (requestPath.contains("administrativo")
                || requestPath.contains("empresa")
                || requestPath.contains("parametros")
                || requestPath.contains("pessoa")
                || requestPath.contains("renegociacao")
                || requestPath.contains("seguranca")
                || requestPath.contains("titulo")) {

            if (usuarioSessaoCtr.isLogado()) {

                chain.doFilter(request, response);
//                    ((HttpServletResponse) response).sendRedirect("/HelenaFace/usersystem/painel.xhtml");
                //chain.doFilter(request, response);

            } else {
                ((HttpServletResponse) response).sendRedirect("/Cobranca360/entrar.xhtml?faces-redirect=true");
            }

        } else {
            chain.doFilter(request, response);
        }

    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {

    }

}
