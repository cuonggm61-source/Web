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

    // Gắn click cho tất cả ảnh js-lightbox (bao gồm wide-photo)
    document.querySelectorAll('.js-lightbox').forEach((img) => {
        img.style.cursor = 'pointer';
        img.addEventListener('click', () => {
            const src = img.dataset.src || img.src;
            const idx = lightboxImages.findIndex(l => l.src === src);
            openLightbox(idx >= 0 ? idx : 0);
        });
    });

    // Gắn click cho toàn bộ .gallery-item (để click vào bất kỳ vị trí nào trong card)
    document.querySelectorAll('.gallery-item').forEach((item) => {
        item.addEventListener('click', () => {
            const img = item.querySelector('.js-lightbox');
            if (!img) return;
            const src = img.dataset.src || img.src;
            const idx = lightboxImages.findIndex(l => l.src === src);
            openLightbox(idx >= 0 ? idx : 0);
        });
    });

    // Wide photo container click
    const wideContainer = document.querySelector('.wide-photo-container');
    if (wideContainer) {
        wideContainer.style.cursor = 'pointer';
        wideContainer.addEventListener('click', () => {
            const wideImg = wideContainer.querySelector('.js-lightbox');
            if (wideImg) {
                const src = wideImg.dataset.src || wideImg.src;
                const idx = lightboxImages.findIndex(l => l.src === src);
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


// ── 8. TYPING EFFECT ─────────────────────────────────────────────────────────
const typingElement = document.getElementById('typing-text');
const phrases = [
    "Photography · Adventure · Life",
    "Xin chào, mình là Cường...",
    "Đam mê nhiếp ảnh và xê dịch...",
    "Lưu giữ những khoảnh khắc đẹp..."
];
let phraseIndex = 0;
let charIndex = 0;
let isDeleting = false;

function typeEffect() {
    if (!typingElement) return;
    const currentPhrase = phrases[phraseIndex];
    
    if (isDeleting) {
        typingElement.textContent = currentPhrase.substring(0, charIndex - 1);
        charIndex--;
    } else {
        typingElement.textContent = currentPhrase.substring(0, charIndex + 1);
        charIndex++;
    }

    let typeSpeed = isDeleting ? 40 : 80;

    if (!isDeleting && charIndex === currentPhrase.length) {
        typeSpeed = 2000; // Wait before deleting
        isDeleting = true;
    } else if (isDeleting && charIndex === 0) {
        isDeleting = false;
        phraseIndex = (phraseIndex + 1) % phrases.length;
        typeSpeed = 500; // Wait before typing next
    }

    setTimeout(typeEffect, typeSpeed);
}

if (typingElement) {
    setTimeout(typeEffect, 1000);
}

// ── 9. DARK/LIGHT MODE TOGGLE ────────────────────────────────────────────────
const themeToggleBtn = document.getElementById('theme-toggle');
const body = document.body;
const themeIcon = themeToggleBtn ? themeToggleBtn.querySelector('i') : null;

// Check local storage for theme
const savedTheme = localStorage.getItem('theme');
if (savedTheme === 'dark') {
    body.classList.add('dark-mode');
    if (themeIcon) {
        themeIcon.classList.remove('ti-light-bulb');
        themeIcon.classList.add('ti-shine'); // Or any sun icon
    }
}

if (themeToggleBtn) {
    themeToggleBtn.addEventListener('click', () => {
        body.classList.toggle('dark-mode');
        const isDark = body.classList.contains('dark-mode');
        
        if (isDark) {
            localStorage.setItem('theme', 'dark');
            themeIcon.classList.remove('ti-light-bulb');
            themeIcon.classList.add('ti-shine');
        } else {
            localStorage.setItem('theme', 'light');
            themeIcon.classList.remove('ti-shine');
            themeIcon.classList.add('ti-light-bulb');
        }
    });
}

// ── 10. INTERACTIVE MAP ──────────────────────────────────────────────────────
const mapContainer = document.getElementById('travel-map');
if (mapContainer && typeof L !== 'undefined') {
    // Tọa độ trung tâm: Việt Nam
    const map = L.map('travel-map').setView([16.0471, 106.0000], 5);
    
    // Theme dark for map tiles
    L.tileLayer('https://{s}.basemaps.cartocdn.com/rastertiles/voyager/{z}/{x}/{y}{r}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors &copy; <a href="https://carto.com/attributions">CARTO</a>',
        subdomains: 'abcd',
        maxZoom: 20
    }).addTo(map);

    const locations = [
        { name: "Cát Bà, Hải Phòng", coords: [20.7262, 107.0456] },
        { name: "Đồ Sơn, Hải Phòng", coords: [20.7090, 106.7909] },
        { name: "Hải Phòng (Trung tâm)", coords: [20.8449, 106.6881] },
        { name: "Hà Giang", coords: [22.8233, 104.9839] },
        { name: "Tà Xùa, Sơn La", coords: [21.2652, 104.3168] },
        { name: "Tam Đảo, Vĩnh Phúc", coords: [21.4578, 105.6475] },
        { name: "Hạ Long, Quảng Ninh", coords: [20.9500, 107.0167] },
        { name: "Quảng Ninh (Trung tâm)", coords: [21.0065, 107.2925] },
        { name: "Ninh Bình", coords: [20.2539, 105.9750] },
        { name: "Hà Nội", coords: [21.0285, 105.8048] },
        { name: "Thái Nguyên", coords: [21.5942, 105.8446] },
        { name: "Phú Thọ", coords: [21.3653, 105.2174] },
        { name: "Sapa, Lào Cai", coords: [22.3364, 103.8438] },
        { name: "Đà Nẵng", coords: [16.0471, 108.2062] },
        { name: "Đà Lạt, Lâm Đồng", coords: [11.9404, 108.4583] }
    ];

    locations.forEach(loc => {
        L.marker(loc.coords).addTo(map)
            .bindPopup(`<b>${loc.name}</b>`);
    });
}

// ── 11. MUSIC PLAYER ─────────────────────────────────────────────────────────
const musicPlayer = document.getElementById('music-player');
const bgMusic = document.getElementById('bg-music');

if (musicPlayer && bgMusic) {
    // Attempt autoplay
    bgMusic.play().then(() => {
        musicPlayer.classList.add('playing');
    }).catch(err => {
        // Autoplay blocked by browser policy, wait for first click anywhere
        document.body.addEventListener('click', function initAudio() {
            bgMusic.play();
            musicPlayer.classList.add('playing');
            document.body.removeEventListener('click', initAudio);
        }, { once: true });
    });

    musicPlayer.addEventListener('click', (e) => {
        e.stopPropagation(); // Ngăn chặn sự kiện click lan ra body
        if (bgMusic.paused) {
            bgMusic.play();
            musicPlayer.classList.add('playing');
        } else {
            bgMusic.pause();
            musicPlayer.classList.remove('playing');
        }
    });
}
