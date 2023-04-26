DESCRIPTION = "MicroPython is a lean and fast implementation of the Python 3 programming language"
HOMEPAGE = "https://micropython.org"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a8a14efdd86622bc2a34296228779da7"

inherit autotools-brokensep

INC_PR = "r1"
PR = "${INC_PR}.0"

SRC_URI = " \
	gitsm://github.com/micropython/micropython.git;name=src;tag=v${PV} \
"

S = "${WORKDIR}/git"

DEPENDS = "libffi"

CPPFLAGS_append = " -Wno-error"

EXTRA_OEMAKE = " \
	-C ${S}/port/unix \
	V=1 \
	DESTDIR="${D}" \
	CC="${CC}" \
	LD="${LD}" \
	CROSS_COMPILE="${TARGET_PREFIX}" \
	PREFIX="${D}/usr" \
"

do_compile() {
	oe_runmake micropython
}

do_configure() {
	:
}

RRECOMMENDS_${PN} = "micropython-lib"

INSANE_SKIP_${PN} = "already-stripped"

BBCLASSEXTEND = "native"

