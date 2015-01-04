/*
 * Copyright (c) 2011-2014 Fernando Petrola
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dragome.html.dom.w3c;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.dragome.commons.javascript.ScriptHelper;
import com.dragome.enhancers.jsdelegate.JsDelegateFactory;
import com.dragome.html.dom.DomHandler;

public class BrowserDomHandler implements DomHandler
{
	protected Document document;

	public BrowserDomHandler()
	{
	}

	public Document getDocument()
	{
		if (document == null)
			init();

		return document;
	}

	private void init()
	{
		if (document == null)
		{
			Object documentNode= ScriptHelper.eval("document", this);
			document= JsDelegateFactory.createFrom(documentNode, Document.class);
		}
	}

	public void setDocument(Document document)
	{
		this.document= document;
	}

	public Element getElementBySelector(String selector)
	{
		ScriptHelper.put("selector", selector, this);
		Object object= ScriptHelper.eval("document.querySelectorAll(selector)[0]", this);
		Element result= JsDelegateFactory.createFrom(object, Element.class);
		return result;
	}

	public void initDocument()
	{
		init();
	}
}
