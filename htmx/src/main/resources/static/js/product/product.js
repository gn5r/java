function formData() {
  return {
    form: {
      name: '',
      priceSince: '',
      priceUntil: '',
      stockSince: '',
      stockUntil: ''
    },
    init() {
      Object.keys(this.form).forEach(k => this.form[k] = this.$refs[k].value);
    },
    resetForm() {
      this.form = {
        name: '',
        priceSince: '',
        priceUntil: '',
        stockSince: '',
        stockUntil: ''
      };
    }
  }
}

function page(page) {
  const url = new URL(window.location.href);
  url.searchParams.set("page", page);
  window.location.href = url.toString();
}

function changePageSize(el) {
  const pageSize = el.value;
  const url = new URL(window.location.href);
  url.searchParams.set("size", pageSize);
  window.location.href = url.toString();
}