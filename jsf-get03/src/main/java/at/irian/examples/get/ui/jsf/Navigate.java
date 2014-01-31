package at.irian.examples.get.ui.jsf;

import java.util.LinkedHashMap;
import java.util.Map;

public class Navigate {
    private final String viewId;
    private final Map<String, String> parameters = new LinkedHashMap<>();
    private boolean redirect = false;
    private boolean includeViewParams = false;

    public static Navigate to(String viewId) {
        return new Navigate(viewId);
    }

    private Navigate(String viewId) {
        this.viewId = viewId;
    }

    public Navigate withRedirect() {
        this.redirect = true;
        return this;
    }

    public Navigate withIncludeViewParams() {
        this.includeViewParams = true;
        return this;
    }

    public Navigate withParameter(String key, String value) {
        parameters.put(key, value);
        return this;
    }

    public String build() {
        OutcomeBuilder outcomeBuilder = new OutcomeBuilder(viewId);
        for (Map.Entry<String, String> parameterEntry : parameters.entrySet()) {
            outcomeBuilder.appendParameter(parameterEntry.getKey(), parameterEntry.getValue());
        }
        if (redirect) {
            outcomeBuilder.appendParameter("faces-redirect", "true");
        }
        if (includeViewParams) {
            outcomeBuilder.appendParameter("faces-include-view-params", "true");
        }
        return outcomeBuilder.build();
    }

    private static class OutcomeBuilder {
        private final StringBuilder outcomeStringBuilder = new StringBuilder();
        private boolean firstParameter = true;

        OutcomeBuilder(String viewId) {
            outcomeStringBuilder.append(viewId);
        }

        void appendParameter(String key, String value) {
            appendParameterSeparator();
            doAppendParameter(key, value);
        }

        String build() {
            return outcomeStringBuilder.toString();
        }

        private void appendParameterSeparator() {
            if (firstParameter) {
                outcomeStringBuilder.append("?");
                firstParameter = false;
            } else {
                outcomeStringBuilder.append("&");
            }
        }

        private void doAppendParameter(String key, String value) {
            outcomeStringBuilder.append(key);
            outcomeStringBuilder.append("=");
            outcomeStringBuilder.append(value);
        }
    }
}
