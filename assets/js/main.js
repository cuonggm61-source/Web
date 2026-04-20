/* =============================================================================
   main.js - CuongThinh Photography Website
   Includes: Scroll Reveal, Hamburger Menu, Lightbox, Scroll-to-Top
   ============================================================================= */

// ── 1. HEADER: Transparent → Solid on scroll ─────────────────────────────────
const header = document.getElementById('header');
window.addEventListener('scroll', () => {
    if (window.scrollY > 60) {
        header.classList.add('scrolled');
    } else {
        header.classList.remove('scrolled');
    }
});

// ── 2. HAMBURGER MENU ─────────────────────────────────────────────────────────
const hamburger = document.getElementById('hamburger');
const mobileNav = document.getElementById('mobile-nav');
const mobileNavOverlay = document.getElementById('mobile-nav-overlay');

hamburger.addEventListener('click', () => {
    hamburger.classList.toggle('open');
    mobileNav.classList.toggle('open');
    mobileNavOverlay.classList.toggle('open');
    document.body.style.overflow = mobileNav.classList.contains('open') ? 'hidden' : '';
});

function closeMobileNav() {
    hamburger.classList.remove('open');
    mobileNav.classList.remove('open');
    mobileNavOverlay.classList.remove('open');
    document.body.style.overflow = '';
}

// ── 3. SCROLL REVEAL (Intersection Observer) ──────────────────────────────────
const revealElements = document.querySelectorAll('.reveal-up, .reveal-scale');

const revealObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('visible');
            revealObserver.unobserve(entry.target); // Only animate once
        }
    });
}, {
    threshold: 0.15,
    rootMargin: '0px 0px -50px 0px'
});

revealElements.forEach(el => revealObserver.observe(el));

// ── 4. LIGHTBOX ───────────────────────────────────────────────────────────────
const lightbox = document.getElementById('lightbox');
const lightboxImg = document.getElementById('lightbox-img');
const lightboxClose = document.getElementById('lightbox-close');
const lightboxPrev = document.getElementById('lightbox-prev');
const lightboxNext = document.getElementById('lightbox-next');

// Gather all lightbox-able images
let lightboxImages = [];
let currentLightboxIndex = 0;

function buildLightboxList() {
    lightboxImages = [...document.querySelectorAll('.js-lightbox')].map(img => ({
        src: img.dataset.src || img.src,
        alt: img.alt || ''
    }));
}

function openLightbox(index) {
    if (index < 0 || index >= lightboxImages.length) return;
    currentLightboxIndex = index;
    lightboxImg.src = lightboxImages[index].src;
    lightboxImg.alt = lightboxImages[index].alt;
    lightbox.classList.add('open');
    document.body.style.overflow = 'hidden';
}

function closeLightbox() {
    lightbox.classList.remove('open');
    document.body.style.overflow = '';
    setTimeout(() => { lightboxImg.src = ''; }, 300);
}

function prevLightbox() {
    const newIndex = (currentLightboxIndex - 1 + lightboxImages.length) % lightboxImages.length;
    openLightbox(newIndex);
}

function nextLightbox() {
    const newIndex = (currentLightboxIndex + 1) % lightboxImages.length;
    openLightbox(newIndex);
}

// Attach click events AFTER DOM is ready
document.addEventListener('DOMContentLoaded', () => {
    buildLightboxList();

    document.querySelectorAll('.js-lightbox').forEach((img, i) => {
        img.addEventListener('click', () => openLightbox(i));
    });

    // Also make wide-photo-container clickable
    const wideContainer = document.querySelector('.wide-photo-container');
    if (wideContainer) {
        wideContainer.addEventListener('click', () => {
            const wideImg = wideContainer.querySelector('.js-lightbox');
            if (wideImg) {
                const idx = lightboxImages.findIndex(l => l.src === (wideImg.dataset.src || wideImg.src));
                openLightbox(idx >= 0 ? idx : 0);
            }
        });
    }
});

lightboxClose.addEventListener('click', closeLightbox);
lightboxPrev.addEventListener('click', prevLightbox);
lightboxNext.addEventListener('click', nextLightbox);

// Close on overlay click
lightbox.addEventListener('click', (e) => {
    if (e.target === lightbox) closeLightbox();
});

// Keyboard navigation
document.addEventListener('keydown', (e) => {
    if (!lightbox.classList.contains('open')) return;
    if (e.key === 'Escape') closeLightbox();
    if (e.key === 'ArrowLeft') prevLightbox();
    if (e.key === 'ArrowRight') nextLightbox();
});

// ── 5. SCROLL TO TOP ──────────────────────────────────────────────────────────
const scrollTopBtn = document.getElementById('scroll-top');

window.addEventListener('scroll', () => {
    if (window.scrollY > 400) {
        scrollTopBtn.classList.add('visible');
    } else {
        scrollTopBtn.classList.remove('visible');
    }
});

scrollTopBtn.addEventListener('click', () => {
    window.scrollTo({ top: 0, behavior: 'smooth' });
});

// ── 6. ACTIVE NAV LINK ON SCROLL ─────────────────────────────────────────────
const sections = document.querySelectorAll('div[id]');
const navLinks = document.querySelectorAll('.nav-link');

const sectionObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            navLinks.forEach(link => {
                link.style.color = '';
                if (link.getAttribute('href') === '#' + entry.target.id ||
                    (entry.target.id === 'slider' && link.getAttribute('href') === '#')) {
                    link.style.color = '#3b82f6';
                }
            });
        }
    });
}, { threshold: 0.4 });

sections.forEach(section => sectionObserver.observe(section));
