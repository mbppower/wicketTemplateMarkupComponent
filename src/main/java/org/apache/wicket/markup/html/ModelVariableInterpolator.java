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

import org.apache.wicket.core.util.lang.PropertyResolver;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.interpolator.VariableInterpolator;

/**
 *
 * @author Marcel Barbosa Pinto
 */
public abstract class ModelVariableInterpolator extends VariableInterpolator {

    /**
     * Model
     */
    private IModel model;

    /**
     * Constructor.
     *
     * @param string a <code>String</code> to interpolate into
     * @param model the properties to render
     */
    public ModelVariableInterpolator(final String string, final IModel model) {
        super(string);
        this.model = model;
    }

    /**
     * Constructor.
     *
     * @param string a <code>String</code> to interpolate into
     * @param model the properties to render
     * @param exceptionOnNullVarValue if <code>true</code> an {@link IllegalStateException} will be thrown if {@link #getValue(String)} returns <code>null</code>, otherwise the <code>${varname}</code> string will be left in the <code>String</code> so that multiple interpolators can be chained
     */
    public ModelVariableInterpolator(final String string, final IModel model, final boolean exceptionOnNullVarValue) {
        super(string, exceptionOnNullVarValue);
        this.model = model;
    }

    /**
     * Sets the <code>Model</code> of variables.
     *
     * @param model the <code>Model</code> of variables
     */
    public final void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Retrieves a value for a variable name or expression during interpolation.
     *
     * @param expression the variable name or expression
     * @return the value
     */
    @Override
    protected String getValue(final String expression) {
        return getModelPropertyObjectAsString(expression, PropertyResolver.getValue(expression, this.model.getObject()));
    }

    protected abstract String getModelPropertyObjectAsString(String expression, Object object);
}
