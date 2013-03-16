require recipes-multimedia/gstreamer/gst-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+ & LGPLv2.1+ "
LIC_FILES_CHKSUM = "file://COPYING;md5=55ca817ccb7d5b5b66355690e9abc605"

SRC_URI[md5sum] = "ac70ede13f79978d56eaed8abaa3c938"
SRC_URI[sha256sum] = "48340b6a4b8abce16344a7bc33e74a94fdcce4f57ef6342cdf2f941c429bf210"

SRC_URI += " file://0001-conditional-gl-framebuffer-undefined-use.patch"

DEPENDS += "gst-plugins-base jpeg"
DEPENDS_append_arm = " virtual/libgles2 virtual/egl "
DEPENDS_append_i586 = " glew "

inherit gettext gconf

# This package doesn't have a configure switch for EGL or GL, so forcibly tell
# configure that it can't find gl.h so it always uses EGL.  If/when we have some
# way for machines to specify their preferred GL flavour this can be
# automatically adapted.
EXTRA_OECONF_append_arm = " ac_cv_header_GL_gl_h=no"
EXTRA_OECONF_append_i586 = " ac_cv_header_GL_gl_h=yes"

ALLOW_EMPTY_${PN} = "1"
ALLOW_EMPTY_${PN}-apps = "1"
ALLOW_EMPTY_${PN}-glib = "1"
