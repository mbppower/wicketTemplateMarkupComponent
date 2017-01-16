/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.markup.html;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.model.IModel;

/**
 * A TemplateMarkupContainer component replaces its body with the rendered properties of its model object.
 *
 * @author Marcel Barbosa Pinto
 */
public class TemplateMarkupContainer extends WebComponent {

    private static final long serialVersionUID = 1L;
    private boolean exceptionOnNullVarValue = true;

    /**
     * Constructor.
     *
     * @param id
     * @param model
     * @see org.apache.wicket.Component#Component(String, IModel)
     */
    public TemplateMarkupContainer(final String id, IModel<?> model) {
        super(id, model);
    }

    /**
     * Constructor.
     *
     * {@inheritDoc}
     *
     * @param exceptionOnNullVarValue if <code>true</code> an {@link IllegalStateException} will be thrown if {@link #getValue(String)} returns <code>null</code>, otherwise the <code>${varname}</code> string will be left in the <code>String</code> so that multiple interpolators can be chained
     */
    public TemplateMarkupContainer(final String id, IModel<?> model, final boolean exceptionOnNullVarValue) {
        super(id, model);
        this.exceptionOnNullVarValue = exceptionOnNullVarValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
        ModelVariableInterpolator interpolator = new ModelVariableInterpolator(markupStream.get().toString(), getDefaultModel(), exceptionOnNullVarValue) {
            @Override
            protected String getModelPropertyObjectAsString(String expression, Object object) {
                return onValue(expression, object);
            }
        };

        replaceComponentTagBody(markupStream, openTag, interpolator.toString());
    }
	
	/**
	 * Can be overriden to replace values
	 * @param expression the variable expression
	 * @param value the property value
	 * @return the String representation to be rendered
	 */
	protected String onValue(String expression, Object value){
		return getDefaultModelObjectAsString(value);
	}
}
