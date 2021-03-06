/*
 * Copyright (c) 2019, the Dart project authors. Please see the AUTHORS file
 * for details. All rights reserved. Use of this source code is governed by a
 * BSD-style license that can be found in the LICENSE file.
 *
 * This file has been automatically generated. Please do not edit it manually.
 * To regenerate the file, use the script "pkg/analysis_server/tool/spec/generate_files".
 */
package org.dartlang.analysis.server.protocol;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Lists;
import com.google.dart.server.utilities.general.JsonUtilities;
import com.google.dart.server.utilities.general.ObjectUtilities;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/**
 * A partial completion suggestion that can be used in combination with info from
 * completion.results to build completion suggestions for not yet imported library tokens.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class AvailableSuggestion {

  public static final AvailableSuggestion[] EMPTY_ARRAY = new AvailableSuggestion[0];

  public static final List<AvailableSuggestion> EMPTY_LIST = Lists.newArrayList();

  /**
   * The identifier to present to the user for code completion.
   */
  private final String label;

  /**
   * Information about the element reference being suggested.
   */
  private final Element element;

  /**
   * A default String for use in generating argument list source contents on the client side.
   */
  private final String defaultArgumentListString;

  /**
   * Pairs of offsets and lengths describing 'defaultArgumentListString' text ranges suitable for use
   * by clients to set up linked edits of default argument source contents. For example, given an
   * argument list string 'x, y', the corresponding text range [0, 1, 3, 1], indicates two text
   * ranges of length 1, starting at offsets 0 and 3. Clients can use these ranges to treat the 'x'
   * and 'y' values specially for linked edits.
   */
  private final int[] defaultArgumentListTextRanges;

  /**
   * The Dartdoc associated with the element being suggested. This field is omitted if there is no
   * Dartdoc associated with the element.
   */
  private final String docComplete;

  /**
   * An abbreviated version of the Dartdoc associated with the element being suggested. This field is
   * omitted if there is no Dartdoc associated with the element.
   */
  private final String docSummary;

  /**
   * If the element is an executable, the names of the formal parameters of all kinds - required,
   * optional positional, and optional named. The names of positional parameters are empty strings.
   * Omitted if the element is not an executable.
   */
  private final List<String> parameterNames;

  /**
   * If the element is an executable, the declared types of the formal parameters of all kinds -
   * required, optional positional, and optional named. Omitted if the element is not an executable.
   */
  private final List<String> parameterTypes;

  /**
   * This field is set if the relevance of this suggestion might be changed depending on where
   * completion is requested.
   */
  private final List<String> relevanceTags;

  private final Integer requiredParameterCount;

  /**
   * Constructor for {@link AvailableSuggestion}.
   */
  public AvailableSuggestion(String label, Element element, String defaultArgumentListString, int[] defaultArgumentListTextRanges, String docComplete, String docSummary, List<String> parameterNames, List<String> parameterTypes, List<String> relevanceTags, Integer requiredParameterCount) {
    this.label = label;
    this.element = element;
    this.defaultArgumentListString = defaultArgumentListString;
    this.defaultArgumentListTextRanges = defaultArgumentListTextRanges;
    this.docComplete = docComplete;
    this.docSummary = docSummary;
    this.parameterNames = parameterNames;
    this.parameterTypes = parameterTypes;
    this.relevanceTags = relevanceTags;
    this.requiredParameterCount = requiredParameterCount;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof AvailableSuggestion) {
      AvailableSuggestion other = (AvailableSuggestion) obj;
      return
        ObjectUtilities.equals(other.label, label) &&
        ObjectUtilities.equals(other.element, element) &&
        ObjectUtilities.equals(other.defaultArgumentListString, defaultArgumentListString) &&
        Arrays.equals(other.defaultArgumentListTextRanges, defaultArgumentListTextRanges) &&
        ObjectUtilities.equals(other.docComplete, docComplete) &&
        ObjectUtilities.equals(other.docSummary, docSummary) &&
        ObjectUtilities.equals(other.parameterNames, parameterNames) &&
        ObjectUtilities.equals(other.parameterTypes, parameterTypes) &&
        ObjectUtilities.equals(other.relevanceTags, relevanceTags) &&
        ObjectUtilities.equals(other.requiredParameterCount, requiredParameterCount);
    }
    return false;
  }

  public static AvailableSuggestion fromJson(JsonObject jsonObject) {
    String label = jsonObject.get("label").getAsString();
    Element element = Element.fromJson(jsonObject.get("element").getAsJsonObject());
    String defaultArgumentListString = jsonObject.get("defaultArgumentListString") == null ? null : jsonObject.get("defaultArgumentListString").getAsString();
    int[] defaultArgumentListTextRanges = jsonObject.get("defaultArgumentListTextRanges") == null ? null : JsonUtilities.decodeIntArray(jsonObject.get("defaultArgumentListTextRanges").getAsJsonArray());
    String docComplete = jsonObject.get("docComplete") == null ? null : jsonObject.get("docComplete").getAsString();
    String docSummary = jsonObject.get("docSummary") == null ? null : jsonObject.get("docSummary").getAsString();
    List<String> parameterNames = jsonObject.get("parameterNames") == null ? null : JsonUtilities.decodeStringList(jsonObject.get("parameterNames").getAsJsonArray());
    List<String> parameterTypes = jsonObject.get("parameterTypes") == null ? null : JsonUtilities.decodeStringList(jsonObject.get("parameterTypes").getAsJsonArray());
    List<String> relevanceTags = jsonObject.get("relevanceTags") == null ? null : JsonUtilities.decodeStringList(jsonObject.get("relevanceTags").getAsJsonArray());
    Integer requiredParameterCount = jsonObject.get("requiredParameterCount") == null ? null : jsonObject.get("requiredParameterCount").getAsInt();
    return new AvailableSuggestion(label, element, defaultArgumentListString, defaultArgumentListTextRanges, docComplete, docSummary, parameterNames, parameterTypes, relevanceTags, requiredParameterCount);
  }

  public static List<AvailableSuggestion> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    ArrayList<AvailableSuggestion> list = new ArrayList<AvailableSuggestion>(jsonArray.size());
    Iterator<JsonElement> iterator = jsonArray.iterator();
    while (iterator.hasNext()) {
      list.add(fromJson(iterator.next().getAsJsonObject()));
    }
    return list;
  }

  /**
   * A default String for use in generating argument list source contents on the client side.
   */
  public String getDefaultArgumentListString() {
    return defaultArgumentListString;
  }

  /**
   * Pairs of offsets and lengths describing 'defaultArgumentListString' text ranges suitable for use
   * by clients to set up linked edits of default argument source contents. For example, given an
   * argument list string 'x, y', the corresponding text range [0, 1, 3, 1], indicates two text
   * ranges of length 1, starting at offsets 0 and 3. Clients can use these ranges to treat the 'x'
   * and 'y' values specially for linked edits.
   */
  public int[] getDefaultArgumentListTextRanges() {
    return defaultArgumentListTextRanges;
  }

  /**
   * The Dartdoc associated with the element being suggested. This field is omitted if there is no
   * Dartdoc associated with the element.
   */
  public String getDocComplete() {
    return docComplete;
  }

  /**
   * An abbreviated version of the Dartdoc associated with the element being suggested. This field is
   * omitted if there is no Dartdoc associated with the element.
   */
  public String getDocSummary() {
    return docSummary;
  }

  /**
   * Information about the element reference being suggested.
   */
  public Element getElement() {
    return element;
  }

  /**
   * The identifier to present to the user for code completion.
   */
  public String getLabel() {
    return label;
  }

  /**
   * If the element is an executable, the names of the formal parameters of all kinds - required,
   * optional positional, and optional named. The names of positional parameters are empty strings.
   * Omitted if the element is not an executable.
   */
  public List<String> getParameterNames() {
    return parameterNames;
  }

  /**
   * If the element is an executable, the declared types of the formal parameters of all kinds -
   * required, optional positional, and optional named. Omitted if the element is not an executable.
   */
  public List<String> getParameterTypes() {
    return parameterTypes;
  }

  /**
   * This field is set if the relevance of this suggestion might be changed depending on where
   * completion is requested.
   */
  public List<String> getRelevanceTags() {
    return relevanceTags;
  }

  public Integer getRequiredParameterCount() {
    return requiredParameterCount;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    builder.append(label);
    builder.append(element);
    builder.append(defaultArgumentListString);
    builder.append(defaultArgumentListTextRanges);
    builder.append(docComplete);
    builder.append(docSummary);
    builder.append(parameterNames);
    builder.append(parameterTypes);
    builder.append(relevanceTags);
    builder.append(requiredParameterCount);
    return builder.toHashCode();
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("label", label);
    jsonObject.add("element", element.toJson());
    if (defaultArgumentListString != null) {
      jsonObject.addProperty("defaultArgumentListString", defaultArgumentListString);
    }
    if (defaultArgumentListTextRanges != null) {
      JsonArray jsonArrayDefaultArgumentListTextRanges = new JsonArray();
      for (int elt : defaultArgumentListTextRanges) {
        jsonArrayDefaultArgumentListTextRanges.add(new JsonPrimitive(elt));
      }
      jsonObject.add("defaultArgumentListTextRanges", jsonArrayDefaultArgumentListTextRanges);
    }
    if (docComplete != null) {
      jsonObject.addProperty("docComplete", docComplete);
    }
    if (docSummary != null) {
      jsonObject.addProperty("docSummary", docSummary);
    }
    if (parameterNames != null) {
      JsonArray jsonArrayParameterNames = new JsonArray();
      for (String elt : parameterNames) {
        jsonArrayParameterNames.add(new JsonPrimitive(elt));
      }
      jsonObject.add("parameterNames", jsonArrayParameterNames);
    }
    if (parameterTypes != null) {
      JsonArray jsonArrayParameterTypes = new JsonArray();
      for (String elt : parameterTypes) {
        jsonArrayParameterTypes.add(new JsonPrimitive(elt));
      }
      jsonObject.add("parameterTypes", jsonArrayParameterTypes);
    }
    if (relevanceTags != null) {
      JsonArray jsonArrayRelevanceTags = new JsonArray();
      for (String elt : relevanceTags) {
        jsonArrayRelevanceTags.add(new JsonPrimitive(elt));
      }
      jsonObject.add("relevanceTags", jsonArrayRelevanceTags);
    }
    if (requiredParameterCount != null) {
      jsonObject.addProperty("requiredParameterCount", requiredParameterCount);
    }
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("label=");
    builder.append(label + ", ");
    builder.append("element=");
    builder.append(element + ", ");
    builder.append("defaultArgumentListString=");
    builder.append(defaultArgumentListString + ", ");
    builder.append("defaultArgumentListTextRanges=");
    builder.append(StringUtils.join(defaultArgumentListTextRanges, ", ") + ", ");
    builder.append("docComplete=");
    builder.append(docComplete + ", ");
    builder.append("docSummary=");
    builder.append(docSummary + ", ");
    builder.append("parameterNames=");
    builder.append(StringUtils.join(parameterNames, ", ") + ", ");
    builder.append("parameterTypes=");
    builder.append(StringUtils.join(parameterTypes, ", ") + ", ");
    builder.append("relevanceTags=");
    builder.append(StringUtils.join(relevanceTags, ", ") + ", ");
    builder.append("requiredParameterCount=");
    builder.append(requiredParameterCount);
    builder.append("]");
    return builder.toString();
  }

}
