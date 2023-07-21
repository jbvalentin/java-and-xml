<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    exclude-result-prefixes="xs xd"
    version="2.0">
    <xd:doc scope="stylesheet">
        <xd:desc>
            <xd:p><xd:b>Created on:</xd:b> Apr 5, 2017</xd:p>
            <xd:p><xd:b>Author:</xd:b> jbvalent</xd:p>
            <xd:p></xd:p>
        </xd:desc>
    </xd:doc>
    
    
    <xsl:output method="xml" encoding="utf-8" />
    
    <xsl:template match="node() | @*">
    	<xsl:copy>
    		<xsl:apply-templates select="node() | @*"/>
    	</xsl:copy>
    </xsl:template>
    
</xsl:stylesheet>