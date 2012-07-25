/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.wsf.stack.cxf;

import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.jboss.wsf.spi.SPIProvider;
import org.jboss.wsf.spi.SPIProviderResolver;
import org.jboss.wsf.spi.invocation.InvocationType;
import org.jboss.wsf.spi.invocation.WebServiceContextFactory;

/**
 * An XFire invoker for EJB3
 * 
 * @author Thomas.Diesler@jboss.org
 * @author alessio.soldano@jboss.com
 * @since 21-May-2007
 */
public class InvokerEJB3 extends AbstractInvoker
{
   protected WebServiceContext getWebServiceContext(MessageContext msgCtx)
   {
      SPIProvider spiProvider = SPIProviderResolver.getInstance().getProvider();
      WebServiceContextFactory contextFactory = spiProvider.getSPI(WebServiceContextFactory.class);
      return contextFactory.newWebServiceContext(InvocationType.JAXWS_EJB3, msgCtx);
   }
}