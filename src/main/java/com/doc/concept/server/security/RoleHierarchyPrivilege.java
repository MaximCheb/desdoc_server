package com.doc.concept.server.security;

import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

//@Configuration
public class RoleHierarchyPrivilege {
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String systemHierarchy = "admin > system \n system > manager \n manager > user";
        roleHierarchy.setHierarchy(systemHierarchy);
        String projectHierarchy = "create_project > change_project \n change_project > read_project";
        roleHierarchy.setHierarchy(projectHierarchy);
        String conceptHierarchy = "create_concept > change_concept \n change_concept > read_concept";
        roleHierarchy.setHierarchy(conceptHierarchy);
        String catalogHierarchy = "create_catalog > change_catalog \n change_catalog > read_catalog";
        roleHierarchy.setHierarchy(catalogHierarchy);
        return roleHierarchy;
    }
}
