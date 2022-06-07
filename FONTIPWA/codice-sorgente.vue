<template>
  <q-page ref="skiplink" id="main" tabindex="-1" class="pis-page-margin page-fse-sources ">
    <div class="page-container pis-home-padding pis-max-width">
      <pis-page-back-title :route="SERVICES"
        >Tutti i servizi</pis-page-back-title
      >
      <pis-title
        class="q-py-lg"
        color-secondary
        title="Fascicolo sanitario elettronico"
      />
      <!--  INiZIO    INTRODUZIONE-->
      <h3 class="details-info-title text-weight-bold q-my-md">
        Da chi è alimentato il tuo Fascicolo Sanitario Elettronico
      </h3>

      <div class="row q-pt-md">
        <p class="details-info-description">
          In questa pagina è possibile verificare quali fonti (Aziende Sanitarie
          ed Enti) alimentano il tuo Fascicolo Sanitario e con quali tipologie
          di documenti.<br />
          Le Fonti in elenco sono tutte quelle che hanno già avviato
          l'integrazione con il Fascicolo Sanitario Elettronico. <br />
          Tale processo è in continua evoluzione e verrà gradualmente diffuso
          ad altre Strutture Sanitarie.
        </p>
        <p class="details-info-description">
          Le prescrizioni dematerializzate, farmaceutiche e specialistiche sono alimentate
          constantemente dal Ministero dell'economia e delle finanze.
        </p>
      </div>
        <template v-if="!sourceListErr">
          <div class="row q-pt-lg" v-if="sourcesList">
            <p class="details-info-description">
              <strong>Periodi di riferimento: dal {{ startDate }} al {{ endDate }}</strong>
            </p>
          </div>
          <!--   FINE   INTRODUZIONE-->

          <!--      INIZIO FILTRI-->
          <q-card flat class="q-my-md  bg-transparent" v-if="$q.screen.gt.sm">
            <q-card-section class="q-px-none">
              <div class="row q-col-gutter-x-lg items-center">
                <div class="col-auto self-center text-bold">
                  <q-icon name="filter_list" size="sm" class="q-mr-sm" />
                  Filtri
                </div>

                <div class="col col-md-4">
                  <q-select
                    v-model="docTypeSelected"
                    :options="documentsOptions"
                    label="Tipo Documento"
                    input-debounce="0"
                    use-input
                    fill-input
                    hide-selected
                    hide-dropdown-icon
                    dense
                    clearable
                    @input="setFilters"
                    @clear="setFilters"
                    @filter="onDocumentListFilter"
                    @filter-abort="abortDocumentFilter"
                  />
                </div>
                <div class="col col-md-4">
                  <q-select
                    v-model="asrSelected"
                    :options="facilitiesOptions"
                    input-debounce="0"
                    use-input
                    hide-selected
                    hide-dropdown-icon
                    fill-input
                    label="Strutture"
                    dense
                    clearable
                    @filter="onFacilitiesListFilter"
                    @filter-abort="abortFacilitiesFilter"
                    @input="setFilters"
                    @clear="setFilters"
                  />
                </div>
              </div>
            </q-card-section>
          </q-card>
          <template v-else>
            <div
              class="text-right text-bold cursor-pointer "
              @click="toggleFilter()"
              style="z-index:1000"
            >
              <q-icon name="filter_list" size="sm" class="q-mr-sm" />
              Filtri
            </div>

            <div>
              <q-slide-transition>
                <q-card flat class="bg-transparent" v-if="isOpenFilter">
                  <q-card-section class="q-px-none row q-col-gutter-x-lg">
                    <div class="col-12 col-sm-6 q-pb-lg">
                      <q-select
                        v-model="docTypeSelected"
                        :options="documentsOptions"
                        label="Tipo Documento"
                        input-debounce="0"
                        use-input
                        fill-input
                        hide-selected
                        hide-dropdown-icon
                        dense
                        clearable
                        @input="setFilters"
                        @clear="setFilters"
                        @filter="onDocumentListFilter"
                        @filter-abort="abortDocumentFilter"
                      />
                    </div>
                    <div class="col-12 col-sm-6 q-pb-lg">
                      <q-select
                        v-model="asrSelected"
                        :options="facilitiesOptions"
                        input-debounce="0"
                        use-input
                        hide-selected
                        hide-dropdown-icon
                        fill-input
                        label="Strutture"
                        dense
                        clearable
                        @filter="onFacilitiesListFilter"
                        @filter-abort="abortFacilitiesFilter"
                        @input="setFilters"
                        @clear="setFilters"
                      />
                    </div>
                  </q-card-section>
                </q-card>
              </q-slide-transition>
            </div>
          </template>
          <!--FINE FILTRI-->
          <!--      BTN TOGGLE-->
          <div class="q-py-md text-right" v-if="this.$q.screen.gt.sm">
            <q-btn-toggle
              class="fse-btn-toggle"
              unelevated
              :ripple="false"
              v-model="showCards"
              toggle-color="secondary"
              color="white"
              text-color="secondary"
              :options="[
        {value: false, slot:'table'},
        {value: true, slot:'cards'},

      ]"
            >
              <template v-slot:table>
                <div class="row items-center no-wrap" >
                  <q-icon right name="view_list" />
                  <div class="text-center q-ml-md">
                    Tabella
                  </div>
                </div>
              </template>

              <template v-slot:cards>
                <div class="row items-center no-wrap" >
                  <q-icon right name="view_module" />
                  <div class="text-center q-ml-md">
                    Schede
                  </div>

                </div>
              </template>
            </q-btn-toggle>
          </div>

          <div v-if="columns">
            <!--  INiZIO   TABELLA PUBBLICA-->
            <!--      <h6 class="q-mb-sm q-mt-xl">-->
            <!--        <strong-->
            <!--        >Lista delle strutture pubbliche che alimentano il fascicolo</strong-->
            <!--        >-->
            <!--      </h6>-->
            <q-expansion-item
              label="Lista delle strutture pubbliche che alimentano il fascicolo"
              default-opened
              header-class="q-mb-sm q-mt-xl text-h6 fse-expand-title"
            >
              <div class="q-py-md" v-if="publicSources">
                <template v-if="publicSources.length>0">
                  <pis-fse-table :columns="columns" :data="publicSources" :show-cards="showCards" />
                </template>
                <template v-else>
                  <q-banner class="bg-info">
                    Nessuna struttura pubblica trovata in base ai filtri di ricerca.
                  </q-banner>
                </template>

              </div>

            </q-expansion-item>
            <!--  FINE   TABELLA PUBBLICA-->

            <!--  INiZIO   TABELLA PRIVATA-->
            <!--      <h6 class="q-mb-sm q-mt-xl">-->
            <!--        <strong-->
            <!--        >Lista delle strutture private che alimentano il fascicolo</strong-->
            <!--        >-->
            <!--      </h6>-->
            <q-expansion-item
              label="Lista delle strutture private che alimentano il fascicolo"
              default-opened
              header-class="q-mb-sm q-mt-xl text-h6 fse-expand-title"
            >
              <div class="q-py-md" v-if="privateSources">
                <template v-if="privateSources.length>0">
                  <pis-fse-table :columns="columns" :data="privateSources" :show-cards="showCards"/>
                </template>
                <template v-else>
                  <q-banner class="bg-info">
                    Nessuna struttura privata trovata in base ai filtri di ricerca.
                  </q-banner>
                </template>
              </div>
            </q-expansion-item>
            <!--  FINE   TABELLA PRIVATA-->
          </div>
        </template>
      <div class="q-pt-xl"v-else>
        <q-banner class="bg-red-3  q-pa-md pis-banner">
          <p>In questo momento non è possibile visualizzare le fonti (Aziende Sanitarie ed Enti) alimentano il tuo Fascicolo Sanitario.</p>
          <p>Ti invitiamo a riprovare più tardi.</p>
        </q-banner>
      </div>
      <p class="details-info-description q-py-xl">
        <strong>Hai bisogno di aiuto?</strong> Compila il <a :href="assistanceUrl" target="_blank" alt="Modulo di assistenza">modulo</a>.<br>
        Un operatore prenderà in carico la tua richiesta e ti ricontatterà al più presto.
      </p>

    </div>
  </q-page>
</template>

<script>
import PisPageBackTitle from "../components/PisPageBackTitle";
import PisTitle from "../components/PisTitle";
import { SERVICES } from "src/router/routes";
import { getFacilitiesTypes, getFseFonts, getFseSources, getSourcesDocumentsTypes } from '../services/api'
import { deepClone, isEmpty, orderBy, capitalize, DOCUMENT_VALUE } from '../services/utils'
import { date } from "quasar";
import PisFseTable from '../components/PisFseTable'
import {config} from "boot/config";
export default {
  name: "PageFseSources",
  components: { PisFseTable, PisTitle, PisPageBackTitle },
  data() {
    return {
      SERVICES,
      isProd: config.isProd,
      sourcesList: null,
      documentsTypes: null,
      facilitiesTypes:null,
      facilitiesList:[],
      columns:null,
      showCards:false,
      docTypeSelected:'',
      asrSelected:'',
      documentsList:[],
      isOpenFilter:false,
      filteredSourceList:[],
      sourceListErr:false

    };
  },
  computed: {
    startDate() {
      if (!isEmpty(this.sourcesList)) {
        let startdate = this.sourcesList.periodo_riferimento_inizio;
        return startdate ? date.formatDate(startdate, "DD MMMM YYYY") : "";
      }
      return "";
    },
    endDate() {
      if (!isEmpty(this.sourcesList)) {
        let endDate = this.sourcesList.periodo_riferimento_fine;
        return endDate ? date.formatDate(endDate, "DD MMMM YYYY") : "";
      }
      return "";
    },
    publicSources(){
      let publicSources = []
      if (!isEmpty(this.filteredSourceList)) {
        let publiclist= this.filteredSourceList.filter(source => source.natura === '1')
        publicSources = orderBy(publiclist, ['descrizione_asr'])
      }
      return publicSources
    },
    privateSources(){
      let privateSources = []
      if (!isEmpty(this.filteredSourceList)) {
        let privateList = this.filteredSourceList.filter(source => source.natura === '2' || source.natura === '3')
        privateSources = orderBy(privateList, ['descrizione_asr'])
      }
      return privateSources
    },
    documentsOptions(){
      let orderedOptions = []
      if(this.documentsList.length>0){
        let list = deepClone(this.documentsList)
        let options = list.map(doc => {
          return {label: capitalize(doc.descrizione,true), value:doc.codice}
        })

        orderedOptions = orderBy(options, ['label'])
      }
      return orderedOptions
    },
    facilitiesOptions(){
      let orderedOptions = []
      if(this.facilitiesList.length>0){
        let list = deepClone(this.facilitiesList)
        let options = list.map(asr => {
          return {label: asr.azienda_descrizione, value: asr.azienda_codice , natura: asr.natura_id, _model: asr}
        })
        orderedOptions = orderBy(options, ['label'])
      }
      return orderedOptions
    },
    assistanceUrl(){

        return 'url'
    }

  },
  created() {
    this.$q.loading.hide();
    this.getSourcesData();
    this.getDefaultData()
  },
  methods: {
    async getDefaultData(){
      try{
        let docresponse = await getSourcesDocumentsTypes();
        let facilitiesresponse = await getFacilitiesTypes();
        this.documentsTypes = docresponse.data;
        this.documentsList = this.documentsTypes
        if (this.documentsTypes) this.getDocumentsColumns()
        this.facilitiesTypes = facilitiesresponse.data;
      }catch (e) {

      }
    },
    async getSourcesData () {
      try {
        let response = await getFseSources();
        this.sourcesList = response.data;
        if (this.sourcesList) this.mapSourcesData()
      }catch (e) {
        console.log(e)
        this.sourceListErr = true
      }
    },
    mapSourcesData () {
      let sourcesList = this.sourcesList.elenco_asr
      if(sourcesList){

        let mappedSources = sourcesList.map(source => {
            source.documenti_inviati = source.documenti_inviati.filter(doc => doc.valore_alimentazione === DOCUMENT_VALUE)
            return source
        })
        this.sourcesList.elenco_asr = mappedSources.filter(source => source.documenti_inviati.length > 0 )

      }
      this.filteredSourceList = deepClone(this.sourcesList.elenco_asr)
      // if(sourcesList){
      //  let mapSourcesList = sourcesList.map(source => {
      //    let documentsList = source.documenti_inviati
      //    let listdocs = documentsList.reduce((obj,docs) => {
      //
      //      obj[docs.codice_documento] = obj[docs.codice_documento] || []
      //      obj[docs.codice_documento] = docs.valore_alimentazione === 'S'
      //      return obj
      //    }, {})
      //     source.documenti = listdocs
      //     delete source['documenti_inviati']
      //    return source
      //  })
      //   console.log('mapSourcesList', mapSourcesList)

    },
    getDocumentsColumns () {
      let documentsList = deepClone(this.documentsTypes)
      let firstColumn = [{
        name: 'sourceName',
        required: true,
        label: 'Struttura',
        align:'center',
        field: row => row.descrizione_asr
      }]
      let mappedList = documentsList.map(doc => {
        return {
          name: doc.codice,
          label: capitalize(doc.descrizione, true),
          align:'center',
          field: doc.codice
        }
      })
      this.columns = [...firstColumn, ...mappedList]
    },
    setFilters(value) {
      this.filteredSourceList = [];
      this.sourcesList.elenco_asr.forEach(source => {
        if (
          this.filterByDocumentType(source) &&
          this.filterByFacility(source)
        )
          this.filteredSourceList.push(source);


        console.log( this.filterByDocumentType(source))
        console.log(  this.filterByFacility(source))
      });
    },
    filterByDocumentType(asr) {
      let docList = asr.documenti_inviati
      if (!isEmpty(this.docTypeSelected)) {
        let list = docList.find(doc => doc.codice_documento === this.docTypeSelected.value && doc.valore_alimentazione === DOCUMENT_VALUE)
        return !isEmpty(list)
      } else {
        return true;
      }
    },
    filterByFacility(asr) {
      if (this.asrSelected) {
         return (asr.codice_asr === this.asrSelected?.value?.toString())
      } else {
        return true;
      }
    },
    onDocumentListFilter(val, update, abort){
      if (val === null) {
        abort();
        return;
      }
      setTimeout(() => {
        update(
          () => {
            if (val === "") {
              this.documentsList = Object.freeze(this.documentsTypes);
            } else {
              const needle = val.toLowerCase();
              let list = this.documentsTypes.filter(
                v => v.descrizione.toLowerCase().indexOf(needle) > -1
              );

              this.documentsList = Object.freeze(list);
            }
          },

        );
      }, 300);
    },
    abortDocumentFilter(){},
    onFacilitiesListFilter(val, update, abort){
      if (val === null) {
        abort();
        return;
      }
      setTimeout(() => {
        update(
          () => {
            if (val === "") {
              this.facilitiesList = Object.freeze(this.facilitiesTypes);
            } else {
              const needle = val.toLowerCase();
              let list = this.facilitiesTypes.filter(
                v => v.azienda_descrizione.toLowerCase().indexOf(needle) > -1
              );

              this.facilitiesList = Object.freeze(list);
            }
          },


        );
      }, 300);
    },
    abortFacilitiesFilter(){},
    toggleFilter() {
      this.isOpenFilter = !this.isOpenFilter;
    },

  }
};
</script>

<style lang="sass">
  .page-fse-sources
    .fse-btn-toggle
      border: 1px solid $secondary
    .fse-expand-title
      font-weight: bold
      .q-focus-helper
        background: transparent !important
        opacity: 0 !important
      i
        font-size: 2rem !important
        color: #000
</style>
