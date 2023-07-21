<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">

	<xsl:template match="books">
	  <xsl:copy>
	  	<xsl:apply-templates select="@*|node()"/>
	    <index>
	      <xsl:apply-templates select="book" mode="index" />
	    </index>
	  </xsl:copy>
	
	</xsl:template>
	
	
    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>
    
    
    <xsl:template match="book" mode="index">
      <entry>
        <xsl:value-of select="title"/>
        <xsl:text> (</xsl:text>
        <xsl:value-of select="author"/>
        <xsl:text>)</xsl:text>
      </entry>
    
    </xsl:template>

</xsl:stylesheet>