require mali.inc

DESCRIPTION = "Mali t62x GPU Binaries for ODROID-xu3/4"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=35a5069c749a467e2add8d4b1805444b"

TYPE = "mali-t62x"


SRCREV = "e3fbb79c1df377da21b38bd4f57ae1289c59e480"
SRC_URI = "git://github.com/mdrjr/5422_mali.git"

S = "${WORKDIR}/git"

do_install () {
        # Create MALI manifest
        install -m 755 -d ${D}/${libdir}
        if [ "${USE_X11}" = "yes" ]; then
                install ${S}/x11/libmali.so ${D}/${libdir}
        elif [ "${USE_WL}" = "yes" ]; then
                install ${S}/wayland/libmali.so ${D}/${libdir}
        else
                install ${S}/fbdev/libmali.so ${D}/${libdir}
        fi

        ln -sf libmali.so ${D}/${libdir}/libEGL.so
        ln -sf libmali.so ${D}/${libdir}/libGLESv1_CM.so
        ln -sf libmali.so ${D}/${libdir}/libGLESv2.so
        ln -sf libmali.so ${D}/${libdir}/libOpenCL.so
        if [ "${USE_WL}" = "yes" ]; then
                ln -sf libmali.so ${D}/${libdir}/libgbm.so
                ln -sf libmali.so ${D}/${libdir}/libwayland-egl.so
        fi
}

RDEPENDS_${PN} += "kernel-module-mali-t62x"
COMPATIBLE_MACHINE = "odroid-xu3"
