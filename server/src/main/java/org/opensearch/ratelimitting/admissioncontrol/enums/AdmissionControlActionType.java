/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.ratelimitting.admissioncontrol.enums;

import java.util.Locale;

/**
 * Enums that defines the type of the transport requests
 */
public enum AdmissionControlActionType {
    INDEXING("indexing"),
    SEARCH("search"),
    CLUSTER_ADMIN("cluster_admin");

    private final String type;

    AdmissionControlActionType(String uriType) {
        this.type = uriType;
    }

    /**
     *
     * @return type of the request
     */
    public String getType() {
        return type;
    }

    public static AdmissionControlActionType fromName(String name) {
        name = name.toLowerCase(Locale.ROOT);

        for (AdmissionControlActionType type : AdmissionControlActionType.values()) {
            if (type.getType().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Not Supported TransportAction Type: " + name);
    }
}
